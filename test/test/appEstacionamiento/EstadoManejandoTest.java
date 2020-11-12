package test.appEstacionamiento;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.appEstacionamiento.EstadoCaminando;
import tpIntegrador.appEstacionamiento.EstacionamientoApp;
import tpIntegrador.appEstacionamiento.EstadoManejando;

class EstadoManejandoTest {
	private EstacionamientoApp app;
	private EstadoManejando manejando;
	

	@BeforeEach
	void setUp() throws Exception {
		app = mock(EstacionamientoApp.class);
		manejando = new EstadoManejando(app);
	}
	
	@Test
	void testManejandoNoHaceNada() {
		
		manejando.manejando();
		
		verify(app, never()).setEstadoMovimiento(any(EstadoManejando.class));
		verify(app,never()).comenzoACaminar();
	}
	
	@Test
	void testCaminandoCambiaElEstadoYEnviaMensajeComenzoACaminar() {
		
		manejando.caminando();
		verify(app).setEstadoMovimiento(any(EstadoCaminando.class));
		verify(app).comenzoACaminar();
	}
	
}
