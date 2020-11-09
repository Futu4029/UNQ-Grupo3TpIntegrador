package test.appEstacionamiento;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.appEstacionamiento.EstacionamientoApp;
import tpIntegrador.appEstacionamiento.ModoManual;

class ModoManualTest {
	private ModoManual modo;
	private EstacionamientoApp app;
	private Integer celular;
	private String patente;


	@BeforeEach
	void setUp() throws Exception {
		modo = new ModoManual();
		app = mock(EstacionamientoApp.class);
		celular = 155023023;
		patente = "A10ZO";		
	}

	@Test
	void testAlComenzarACaminarElModoManualNoHaceNada() {
		
		modo.comenzoACaminar(app, patente, celular);
		
		verify(app, never()).inicioEstacionamiento(patente, celular);
	}
	
	@Test
	void testAlComenzarAManejarElModoManualNoHaceNada() {
		
		modo.comenzoAManejar(app, celular);
		
		verify(app, never()).finEstacionamiento(celular);
	}

}
