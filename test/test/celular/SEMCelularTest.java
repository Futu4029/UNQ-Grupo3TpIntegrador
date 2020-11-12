package test.celular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCelular.SEMCelular;

class SEMCelularTest {
    //SUT
	SEMCelular semCelular;
	
	@BeforeEach
	public void setUp() {
		semCelular = new SEMCelular();
	
		semCelular.agregar("1122334455", 100f);
		semCelular.agregar("5544332211", 50f);
		semCelular.agregar("6677889900", 300f);
		
	}
	
	@Test
	void testConstructor() {
		assertEquals(3, semCelular.getCelulares().size());
	}
	
	@Test
	void consultarCredito() {
		assertEquals(300, semCelular.consultarCredito("6677889900"));
		assertEquals(0, semCelular.consultarCredito("1111111111"));
	}
	
	@Test
	void recargarCredito() {
		semCelular.recargar("5544332211", 150);
		assertEquals(200, semCelular.consultarCredito("5544332211"));
	}
	
	@Test
	void descontarCredito() {
		semCelular.descontarCredito("6677889900", 40);
		assertEquals(260, semCelular.consultarCredito("6677889900"));
	}
	
	@Test
	void tieneCreditoSuficiente() {
		assertTrue(semCelular.tieneCreditoSuficiente("1122334455", 150));
	}
	
	@Test
	void noTieneCreditoSuficiente() {
		assertFalse(semCelular.tieneCreditoSuficiente("6677889900", 80));
	}
	
	@Test
	void contieneRecargaRealizada() {
		assertTrue(semCelular.contieneRecargaRealizadaDe("1122334455"));
	}

	@Test
	void noContieneRecargaRealizada() {
		assertFalse(semCelular.contieneRecargaRealizadaDe("1234567890"));
	}
	
}