package test.semEstacionamientoTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import tpIntegrador.appEstacionamiento.*;
//import tpIntegrador.SEMCentral;
import tpIntegrador.estacionamiento.EstacionamientoPuntual;
import tpIntegrador.estacionamiento.EstacionamientoVirtual;
import tpIntegrador.semEstacionamiento.SEMEstacionamiento;

class SEMEstacionamientoTest {
	SEMEstacionamiento sut;
	
	@BeforeEach
	void setUp() {
		sut = new SEMEstacionamiento(semCelular, semZona, semSistemaDeAsistencia);
	}
	
	@Test
	void getEstacionamientosTest() {
		assertEquals(2, sut.getEstacionamiento().size());
	}
	
	@Test
	void getHoraInicioFranjaTest() {
		LocalTime respuesta = LocalTime.of(07, 00);
		assertEquals(respuesta, sut.getHoraInicio());
	}
	
	@Test
	void getHoraFinalFranjaTest() {
		LocalTime respuesta = LocalTime.of(20, 00);
		assertEquals(respuesta, sut.getHoraInicio());
	}
	
	@Test
	void inicioEstacionamientoTest() {
		//assert(sut.estaEnFranjaHoraria(e));
	}
	
	@Test
	void finEstacionamiento() {
		//assertTrue(sut.estaEnFranjaHoraria(e));
	}

	@Test
	void estaEnZonaDeEstacionamiento() {
		assertTrue(sut.estaEnZonaDeEstacionamiento());
	}
	
	@Test
	void estaVigentePatenteTest() {
		EstacionamientoPuntual est = mock(EstacionamientoPuntual.class);
		assertTrue(sut.estaVigentePatente("WEE 420"));
	}
	
	@Test
	void estaVigenteCelularTest() {
		assertTrue(sut.estaVigenteCelular("1111-2222"));
	}
	
	@Test
	void buscarEstacionamientoVigenteTest() {
		EstacionamientoVirtual esTest = mock(EstacionamientoVirtual.class);
		when(esTest.getCelular()).thenReturn("1234-1234");
		assertEquals(esTest, sut.buscarEstacionamientoVigente("1234-1234"));
	}
	
	@Test
	void registrarTest() {
		EstacionamientoVirtual esTest = mock(EstacionamientoVirtual.class);
		assertEquals(2, sut.getEstacionamiento().size());
		sut.registrar(esTest);
		assertEquals(3, sut.getEstacionamiento().size());
	}
	
	@Test
	void finalizarTodosEstacionamientosTest() {
		// terminar
		
		assertEquals(3, sut.getEstacionamiento().size());
	}
	
	
}
