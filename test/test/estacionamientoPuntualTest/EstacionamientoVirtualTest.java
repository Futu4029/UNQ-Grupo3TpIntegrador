package test.estacionamientoPuntualTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.estacionamiento.EstacionamientoVirtual;

class EstacionamientoVirtualTest {
	private EstacionamientoVirtual sut;
	private String patente;
	private String nroCelu;
	private LocalTime horaMaxima;
	private LocalTime horaFin;
	
	@BeforeEach
	void setUp() {
		patente = "WEE 420";
		horaMaxima = LocalTime.of(19,00);
		nroCelu = "123";
		sut = new EstacionamientoVirtual(patente, nroCelu, horaMaxima);
	}
	
	@Test
	void cambiosDeVariables() {
		//setup
		horaFin = LocalTime.of(20, 00);
		
		//exercise
		sut.setCelular("asd");
		sut.setEstaVigente(false);
		sut.actualizarHoraFin(horaFin);
		
		//verify
		assertEquals("asd", sut.getCelular());
		assertFalse(sut.estaVigente());
		assertEquals(horaFin, sut.getHoraFinal());
	}
	
	@Test
	void finalizarTest() {
		assertTrue(sut.estaVigente());
		assertEquals(horaMaxima, sut.getHoraFinal());
		sut.finalizar(horaFin);
		assertFalse(sut.estaVigente());
		assertEquals(horaFin, sut.getHoraFinal());
	}
	
	@Test
	void sonNrosIgualesTest() {
		assertTrue(sut.sonNumerosIguales("123"));
	}
	
	@Test
	void noSonNrosIgualesTest() {
		assertFalse(sut.sonNumerosIguales("456"));
	}

}
