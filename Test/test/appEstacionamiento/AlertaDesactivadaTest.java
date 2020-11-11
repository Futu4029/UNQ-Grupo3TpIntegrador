package test.appEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.appEstacionamiento.AlertaDesactivada;

class AlertaDesactivadaTest {
	private AlertaDesactivada alerta;

	@BeforeEach
	void setUp() throws Exception {
		
		alerta = new AlertaDesactivada();
		
	}

	@Test
	void testAlComenzarACaminarNoDeberíaDeNotificar() {
		
		assertEquals(null, alerta.comenzoACaminar());
		
	}

	@Test
	void testAlComenzarAMenjarNoDeberíaDeNotificar() {
		
		assertEquals(null, alerta.comenzoAManejar());
		
	}
	
}
