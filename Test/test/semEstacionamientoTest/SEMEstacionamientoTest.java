package test.semEstacionamientoTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import tpIntegrador.celular.ISEMCelular;
import tpIntegrador.estacionamiento.EstacionamientoPuntual;
import tpIntegrador.estacionamiento.EstacionamientoVirtual;
import tpIntegrador.semEstacionamiento.SEMEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.ISEMSistemaDeAsistencia;
import tpIntegrador.semZona.ISEMZona;

class SEMEstacionamientoTest {
	SEMEstacionamiento sut;
	ISEMCelular semCelular;
	ISEMZona semZona;
	ISEMSistemaDeAsistencia semSistemaDeAsistencia;
	long precioPorHora;
	
	
	@BeforeEach
	void setUp() {
		ISEMCelular semCelular = mock(ISEMCelular.class);
		ISEMZona semZona = mock(ISEMZona.class);
		ISEMSistemaDeAsistencia semAsistencia = mock(ISEMSistemaDeAsistencia.class);
		precioPorHora = 40;
		sut = new SEMEstacionamiento(semCelular, semZona, semAsistencia, precioPorHora);
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
	void inicioEstacionamientoTest() {
		//assert(sut.estaEnFranjaHoraria(e));
	}
	
	@Test
	void finEstacionamiento() {
		//assertTrue(sut.estaEnFranjaHoraria(e));
	}
	
	
	// IMPLEMENTAR ESTO EN estacionamientoApp
	/*@Test
	void estaEnZonaDeEstacionamiento() {
		assertTrue(sut.estaEnZonaDeEstacionamiento());
	}*/
	
	@Test
	void estaVigentePatenteTest() {
		EstacionamientoPuntual est = mock(EstacionamientoPuntual.class);
		sut.estaVigentePatente("WEE 420");
		sut.registrar(est);
		verify(est).sonPatentesIguales("WEE 420");
		verify(est).estaVigente();
	}
	
	@Test
	void estaVigenteCelularTest() {
		EstacionamientoVirtual est = mock(EstacionamientoVirtual.class);
		sut.registrar(est);
		sut.estaVigenteCelular("asd");
		verify(est).sonNumerosIguales("asd");
		verify(est).estaVigente();
	}
	
	@Test
	void buscarEstacionamientoVigenteTest() {
		EstacionamientoVirtual esTest = mock(EstacionamientoVirtual.class);
		sut.registrar(esTest);
		verify(esTest).sonNumerosIguales("1234-1234");
		verify(esTest).estaVigente();
		assertEquals(esTest, sut.buscarEstacionamientoVigente("1234-1234"));
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
