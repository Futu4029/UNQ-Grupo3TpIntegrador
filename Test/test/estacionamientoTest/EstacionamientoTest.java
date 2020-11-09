package test.estacionamientoTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.estacionamiento.Estacionamiento;

import java.time.LocalTime;

class EstacionamientoTest {
	private Estacionamiento sut;
	
	@BeforeEach
	void setUp() {
		sut = new Estacionamiento("WEE 420", LocalTime.of(18, 30));
		sut.setHoraInicio(LocalTime.of(10, 30));
	}
	
	@Test
	void getHoraInicioTest() {
		LocalTime respuesta = LocalTime.of(10, 30); 
		assertEquals(respuesta, sut.getHoraInicio());
	}
	
	@Test
	void getHoraFinTest() {
		LocalTime respuesta = LocalTime.of(18, 30);
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