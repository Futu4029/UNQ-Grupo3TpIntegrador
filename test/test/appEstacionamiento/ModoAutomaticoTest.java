package test.appEstacionamiento;


import static org.mockito.Mockito.*;

import tpIntegrador.appEstacionamiento.EstacionamientoApp;
import tpIntegrador.appEstacionamiento.ModoAutomatico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModoAutomaticoTest {
	private ModoAutomatico modo;
	private EstacionamientoApp app;
	private String celular;
	private String patente;

	@BeforeEach
	void setUp() throws Exception {
		
		modo = new ModoAutomatico();
		app = mock(EstacionamientoApp.class);
		celular = "155023023";
		patente = "A10ZO";		
	}

	@Test
	void testAlComenzarACaminarDeFormaAutomaticaLaAppIniciaUnEstacionamiento() {
		
		modo.comenzoACaminar(app, patente, celular);
		verify(app).inicioEstacionamiento(patente, celular);
	}
	
	@Test
	void testAlComenzarAManerjarDeFormaAutomaticaLaAppFinalizaUnEstacionamiento() {
		modo.comenzoAManejar(app, celular);
		verify(app).finEstacionamiento(celular);
	}

}
