package test.appEstacionamiento;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import tpIntegrador.appEstacionamiento.EstacionamientoApp;
import tpIntegrador.appEstacionamiento.EstadoCaminando;
import tpIntegrador.appEstacionamiento.EstadoMovimiento;

class EstadoMoviemientoAbstractoTest {
	private EstacionamientoApp app;
	private EstadoMovimiento estado;
	
	@BeforeEach
	void setUp() throws Exception {
		app = mock(EstacionamientoApp.class);
		estado = new EstadoCaminando(app);
	}
	

	@Test
	void testPodemosSaberYManipularLaInformacionDeUnEstadoMovimiento() {
		
		estado.setApp(app);
		
		assertEquals(app, estado.getApp());
	}

}
