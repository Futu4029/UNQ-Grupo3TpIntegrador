package test.estacionamientoPuntualTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.estacionamiento.EstacionamientoPuntual;

import java.time.LocalTime;

class EstacionamientoPuntualTest {
	private EstacionamientoPuntual sut;
	
	@BeforeEach
	void setUp() {
		sut = new EstacionamientoPuntual("WEE 420", LocalTime.of(14, 30) , 4);
		sut.setHoraInicio(LocalTime.of(10, 30));
	}
	
	@Test
	void horasHabilitadasTest() {
		assertEquals(4, sut.getHorasHabilitadas());
	}
	
	@Test
	void getHoraInicioTest() {
		LocalTime respuesta = LocalTime.of(10, 30); 
		assertEquals(respuesta, sut.getHoraInicio());
	}
	
	@Test
	void getHoraFinTest() {
		LocalTime respuesta = LocalTime.of(14, 30);
		assertEquals(respuesta, sut.getHoraFinal());
	}
	
	@Test
	void getPatenteTest() {
		assertEquals("WEE 420", sut.getPatente());
	}
	
	@Test
	void sonPatentesIguales() {
		assertTrue(sut.sonPatentesIguales("WEE 420"));
	}	
}
