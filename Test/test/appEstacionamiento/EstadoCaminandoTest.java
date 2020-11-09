package test.appEstacionamiento;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import tpIntegrador.appEstacionamiento.EstadoCaminando;
import tpIntegrador.appEstacionamiento.EstacionamientoApp;
import tpIntegrador.appEstacionamiento.EstadoManejado;

class EstadoCaminandoTest {
	private EstacionamientoApp app;
	private EstadoCaminando caminando;
	

	@BeforeEach
	void setUp() throws Exception {
		
		app = mock(EstacionamientoApp.class);
		caminando = new EstadoCaminando(app);
		
	}

	@Test
	void testCaminandoNoHaceNada() {
		
		caminando.caminando();
		
		verify(app, never()).setEstadoMovimiento(any(EstadoCaminando.class));
		verify(app,never()).comenzoAManejar();
	}

	@Test
	void testManejandoCambiaEstadoYEnviaMensajeComenzoAManejar() {
		caminando.manejando();
		
		verify(app).setEstadoMovimiento(any(EstadoManejado.class));
		verify(app).comenzoAManejar();
	}
}
