package test.appEstacionamiento;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.appEstacionamiento.Caminando;
import tpIntegrador.appEstacionamiento.CompraVirtual;
import tpIntegrador.appEstacionamiento.Manejando;

class ManejandoTest {
	private CompraVirtual app;
	private Manejando manejando;
	

	@BeforeEach
	void setUp() throws Exception {
		app = mock(CompraVirtual.class);
		manejando = new Manejando(app);
	}

	@Test
	void TestManejandoNoHaceNada() {
		
		manejando.manejando();
		
		verify(app, never()).setEstadoMovimiento(any(Manejando.class));
		verify(app,never()).comenzoACaminar();
	}
	
	@Test
	void TestCaminandoCambiaElEstadoYEnviaMensajeComenzoACaminar() {
		
		manejando.caminando();
		verify(app).setEstadoMovimiento(any(Caminando.class));
		verify(app).comenzoACaminar();
	}
	
}
