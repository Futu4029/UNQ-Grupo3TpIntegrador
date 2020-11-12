package test.appInspector;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semZona.*;
import tpIntegrador.appInspector.AppInspector;
import tpIntegrador.semEstacionamiento.*;
import tpIntegrador.semControl.ISEMControl;
import tpIntegrador.semControl.Infraccion;

class AppInspectorTest {
	
	private AppInspector app;
	private String inspector;
	private ISEMControl control;
	private ISEMEstacionamiento estacionamiento;


	@BeforeEach
	void setUp() throws Exception {
		inspector = "Pepe";
		
		control = mock(ISEMControl.class);
		estacionamiento = mock(ISEMEstacionamiento.class);
		
		app = new AppInspector(inspector, control, estacionamiento);
	}

	@Test
	void testPodemosManipularYObtenerInformacionDeAppInspector() {
		String inspector2 = "Mario";
		ISEMControl control2 = mock(ISEMControl.class);
		ISEMEstacionamiento estacionamiento2 = mock(ISEMEstacionamiento.class);
		
		app.setInspector(inspector2 );
		app.setControl(control2);
		app.setEstacionamiento(estacionamiento2);
		
		assertEquals(inspector2, app.getInspector());
		assertEquals(control2, app.getControl());
		assertEquals(estacionamiento2, app.getEstacionamiento());
	}
	
	@Test
	void testPodemosConsultarSiUnaPatenteEstaVigentePorMedioDeIEstacionamiento() {
		String patente = "AZ0Y";
		
		app.estaVigentePatente(patente);
		
		verify(estacionamiento).estaVigentePatente(patente);
		
	}
	
	@Test
	void testPodemosDarDeAltaUnaInfraccionPorMedioDelControl() {
		String patente = "AZ0Y";
		Zona zona = mock(Zona.class);
		
		app.registrarInfraccion(patente, zona);
		
		verify(control).registrarInfraccion(any(Infraccion.class));
		
	}

}
