package test.appEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import tpIntegrador.appEstacionamiento.AlertaActivada;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Verificar los test sobre prints
class AlertaActivadaTest {
	private AlertaActivada alerta; 
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;


	@BeforeEach
	void setUp() throws Exception {
		
		alerta = new AlertaActivada();
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	void restore() {
		System.setOut(originalOut);
	}

	@Test
	void testAlComenzarACaminarAlertaSobreInicioEstacionamiento() {
		
		alerta.comenzoACaminar();
		assertEquals("Deberías iniciar estacionamiento", outContent.toString());
	}
	
	@Test
	void testAlComenzarAManejarAlertaSobreFinEstacionamiento() {
		alerta.comenzoAManejar();
		assertEquals("Deberías finalizar estacionamiento", outContent.toString());
	}

}
