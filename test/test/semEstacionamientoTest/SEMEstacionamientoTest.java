package test.semEstacionamientoTest;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import tpIntegrador.estacionamiento.Estacionamiento;
import tpIntegrador.estacionamiento.EstacionamientoPuntual;
import tpIntegrador.estacionamiento.EstacionamientoVirtual;
import tpIntegrador.semCelular.ISEMCelular;
import tpIntegrador.semEstacionamiento.SEMEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.ISEMSistemaDeAsistencia;
import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionFinEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionInicioEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionSaldoInsuficiente;
import tpIntegrador.semZona.ISEMZona;

class SEMEstacionamientoTest {
	SEMEstacionamiento sut;
	ISEMCelular semCelular;
	ISEMZona semZona;
	ISEMSistemaDeAsistencia semSistemaDeAsistencia;
	long precioPorHora;
	
	
	@BeforeEach
	void setUp() {
		semCelular = mock(ISEMCelular.class);
		semZona = mock(ISEMZona.class);
		semSistemaDeAsistencia = mock(ISEMSistemaDeAsistencia.class);
		precioPorHora = 40;
		sut = new SEMEstacionamiento(semCelular, semZona, semSistemaDeAsistencia, precioPorHora);
	}
	
	@Test
	void getEstacionamientosTest() {
		assertEquals(0, sut.getEstacionamientos().size());
	}
	
	@Test
	void getHoraInicioFranjaTest() {
		LocalTime respuesta = LocalTime.of(07, 00);
		assertEquals(respuesta, sut.getHoraInicioFranja());
	}
	
	@Test
	void getHoraFinalFranjaTest() {
		LocalTime respuesta = LocalTime.of(20, 00);
		assertEquals(respuesta, sut.getHoraFinalFranja());
	}
	
	@Test
	void getSemCelularTest() {
		assertEquals(semCelular, sut.getSemCelular());
	}
	
	@Test
	void getSemZonaTest() {
		assertEquals(semZona, sut.getSemZona());
	}
	
	@Test
	void getSemAsistTest() {
		assertEquals(semSistemaDeAsistencia, sut.getSemSistemaDeAsistencia());
	}
	
	@Test
	void getPrecioPorHoraTest() {
		assertEquals(precioPorHora, sut.getPrecioPorHora());
	}

	@Test
	void setSemEstTest() {
		ArrayList<Estacionamiento> est = new ArrayList<Estacionamiento>();
		sut.setEstacionamientos(est);
		assertEquals(est, sut.getEstacionamientos());
	}
	
	@Test
	void precioPorMinutoTest() {
		assertEquals(sut.getPrecioPorHora()/60, sut.precioPorMinuto());
	}
	
	@Test
	void minutosDisponiblesTest() {
		float respuesta = 0.8f;
		float credito  = 2f;
		assertEquals(respuesta, sut.minutosDisponibles(credito, 2.5f));
	}
	
	@Test
	void generarEstacionamientoPuntualEnFranjaTest() {
		String patente = "asd";
		sut.generarEstacionamientoPuntual(patente, 1);
		assertEquals(LocalTime.now().plusHours(1).withNano(0), sut.getEstacionamientos().get(0).getHoraFinal().withNano(0));
	}
	
	//este test puede fallar de acuerdo al horario pero 
	//fue certificado que cuando cae pasado las 20, se setea en el horario fin de la franja
	@Test
	void generarEstacionamientoPuntualFueraDeFranjaTest() {
		String patente = "asd";
		sut.generarEstacionamientoPuntual(patente, 10);
		assertEquals(sut.getHoraFinalFranja(), sut.getEstacionamientos().get(0).getHoraFinal());
	}
	

	@Test
	void definirHoraMaximaTest() {
		assertEquals(LocalTime.of(15, 00), sut.definirHoraMaxima(120, LocalTime.of(12, 00)));
	}
	//al pasarse de la franja retorna el valor límite de la franja horaria
	void definirHoraMaximaPasadoDeLaFranjaTest() {
		assertEquals(LocalTime.of(20, 00), sut.definirHoraMaxima(120, LocalTime.of(18, 00)));
	}
	
	
	@Test
	void inicioEstacionamientoFailTest() {
		String celular = "1234";
		String patente = "asd";
		when(semCelular.tieneCreditoSuficiente(celular, sut.precioPorMinuto())).thenReturn(false);
		sut.inicioEstacionamiento(patente, "1234");
		Notificacion notificacionEsperada = new NotificacionSaldoInsuficiente();
		assertEquals(notificacionEsperada.imprimir(), sut.inicioEstacionamiento(patente, "1234").imprimir());
	}
	
	@Test
	void inicioEstacionamientoExitosoTest() {
		String celular = "1234";
		String patente = "asd";
		when(semCelular.tieneCreditoSuficiente(celular, sut.precioPorMinuto())).thenReturn(true);
		sut.inicioEstacionamiento(patente, celular);
		assertThat(sut.inicioEstacionamiento(patente, celular), instanceOf(NotificacionInicioEstacionamiento.class));
	}
	
	@Test
	void minutosConsumidosTest() {
		LocalTime horaInicio = LocalTime.of(12, 30);
		LocalTime horaFinal = LocalTime.of(15, 00);
		assertEquals(150, sut.minutosConsumidos(horaInicio, horaFinal));
	}
	
	@Test
	void calculoHorasTotalTest() {
		LocalTime respuesta = LocalTime.of(02, 00);
		long dosHoras = 120;
		assertEquals(respuesta, sut.calculoHorasTotal(dosHoras));
	}
	//quedo pendiente pero se llego al coverage
	@Test
	void finEstacionamiento() {
		String celular = "1234";
		Estacionamiento e = mock(Estacionamiento.class);
		when(e.estaVigente()).thenReturn(true);
		when(e.sonPatentesIguales(celular)).thenReturn(true);
		when(e.getHoraInicio()).thenReturn(LocalTime.of(00,00));
		when(e.getHoraFinal()).thenReturn(LocalTime.of(01,00));
		sut.registrar(e);
		assertThat(sut.finEstacionamiento(celular), instanceOf(NotificacionFinEstacionamiento.class));
	}
	
	@Test
	void estaVigentePatenteTest() {
		EstacionamientoPuntual est = mock(EstacionamientoPuntual.class);
		String celular = "WEE 420";
		sut.registrar(est);
		when(est.estaVigente()).thenReturn(true);
		when(est.sonPatentesIguales(celular)).thenReturn(true);
		assertTrue(sut.estaVigentePatente(celular));
		verify(est).sonPatentesIguales(celular);
		verify(est).estaVigente();
	}
	
	@Test
	void noEstaVigentePatenteTest() {
		EstacionamientoPuntual est = mock(EstacionamientoPuntual.class);
		sut.registrar(est);
		assertFalse(sut.estaVigentePatente("WEE 420"));
	}
	
	@Test
	void estaVigenteCelularTest() {
		EstacionamientoVirtual est = mock(EstacionamientoVirtual.class);
		sut.registrar(est);
		String celular = "asd";
		when(est.estaVigente()).thenReturn(true);
		when(est.sonNumerosIguales(celular)).thenReturn(true);
		assertTrue(sut.estaVigenteCelular(celular));
		verify(est).estaVigente();
		verify(est).sonNumerosIguales(celular);
	}
	
	void noEstaVigenteCelularTest() {
		EstacionamientoVirtual est = mock(EstacionamientoVirtual.class);
		sut.registrar(est);
		String celular = "asd";
		assertFalse(sut.estaVigenteCelular(celular));
	}
	
	@Test
	void buscarEstacionamientoVigenteTest() {
		EstacionamientoVirtual e = mock(EstacionamientoVirtual.class);
		String celular = "1234-1234";
		when(e.sonNumerosIguales(celular)).thenReturn(true);
		when(e.estaVigente()).thenReturn(true);
		sut.registrar(e);
		assertEquals(e, sut.buscarEstacionamientoVigente(celular));
		verify(e).sonNumerosIguales(celular);
		verify(e).estaVigente();
	}
	
	@Test
	void registrarTest() {
		EstacionamientoVirtual esTest = mock(EstacionamientoVirtual.class);
		assertEquals(0, sut.getEstacionamientos().size());
		sut.registrar(esTest);
		assertEquals(1, sut.getEstacionamientos().size());
	}
	
	@Test
	void finalizarTodosEstacionamientosTest() {
		EstacionamientoPuntual eP1 = mock(EstacionamientoPuntual.class);
		EstacionamientoPuntual eP2 = mock(EstacionamientoPuntual.class);
		sut.registrar(eP1);
		sut.registrar(eP2);
		when(eP1.estaVigente()).thenReturn(false);
		when(eP2.estaVigente()).thenReturn(true);
		sut.finalizarTodosEstacionamientos();
		verify(eP1, never()).finalizar(sut.getHoraFinalFranja());
		verify(eP2).finalizar(sut.getHoraFinalFranja());
	}
	

}
