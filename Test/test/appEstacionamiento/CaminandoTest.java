package test.appEstacionamiento;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import tpIntegrador.appEstacionamiento.Caminando;
import tpIntegrador.appEstacionamiento.CompraVirtual;
import tpIntegrador.appEstacionamiento.Manejando;

class CaminandoTest {
	private CompraVirtual app;
	private Caminando caminando;
	

	@BeforeEach
	void setUp() throws Exception {
		
		app = mock(CompraVirtual.class);
		caminando = new Caminando(app);
		
	}

	@Test
	void TestCaminandoNoHaceNada() {
		
		caminando.caminando();
		
		verify(app, never()).setEstadoMovimiento(any(Caminando.class));
		verify(app,never()).comenzoAManejar();
	}

	@Test
	void TestManejandoCambiaEstadoYEnviaMensajeComenzoAManejar() {
		caminando.manejando();
		
		verify(app).setEstadoMovimiento(any(Manejando.class));
		verify(app).comenzoAManejar();
	}
}
