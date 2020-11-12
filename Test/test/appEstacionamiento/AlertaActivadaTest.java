package test.appEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;


import tpIntegrador.appEstacionamiento.AlertaActivada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlertaActivadaTest {
	private AlertaActivada alerta; 



	@BeforeEach
	void setUp() throws Exception {
		
		alerta = new AlertaActivada();
	}
	

	@Test
	void testAlComenzarACaminarAlertaSobreInicioEstacionamiento() {
		
		assertEquals("Deber�as iniciar un estacionamiento", alerta.comenzoACaminar());
	
	}
	
	@Test
	void testAlComenzarAManejarAlertaSobreFinEstacionamiento() {
		
		assertEquals("Deber�as finalizar estacionamiento", alerta.comenzoAManejar());
		
	}

}
