package test.appEstacionamiento;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.appEstacionamiento.EstadoCaminando;
import tpIntegrador.appEstacionamiento.EstacionamientoApp;
import tpIntegrador.appEstacionamiento.EstadoManejado;

class EstadoManejandoTest {
	private EstacionamientoApp app;
	private EstadoManejado manejando;
	

	@BeforeEach
	void setUp() throws Exception {
		app = mock(EstacionamientoApp.class);
		manejando = new EstadoManejado(app);
	}

	@Test
	void testManejandoNoHaceNada() {
		
		manejando.manejando();
		
		verify(app, never()).setEstadoMovimiento(any(EstadoManejado.class));
		verify(app,never()).comenzoACaminar();
	}
	
	@Test
	void testCaminandoCambiaElEstadoYEnviaMensajeComenzoACaminar() {
		
		manejando.caminando();
		verify(app).setEstadoMovimiento(any(EstadoCaminando.class));
		verify(app).comenzoACaminar();
	}
	
}
