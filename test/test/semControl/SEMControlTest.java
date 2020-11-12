package test.semControl;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semControl.Infraccion;
import tpIntegrador.semControl.SEMControl;

class SEMControlTest {
	
	private SEMControl sem;
	private Infraccion infraccion;


	@BeforeEach
	void setUp() throws Exception {
		sem = new SEMControl();
		infraccion = mock(Infraccion.class);
	}

	@Test
	void testElSEMControlSeIniciaSinInfracciones() {
		assertEquals(0, sem.getInfracciones().size());
	}
	
	@Test
	void testPodemosDarDeAltaInfracciones() {
		sem.registrarInfraccion(infraccion);
		
		assertTrue(sem.getInfracciones().contains(infraccion));
	}

}
