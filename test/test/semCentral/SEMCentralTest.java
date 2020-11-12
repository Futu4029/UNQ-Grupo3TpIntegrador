package test.semCentral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import tpIntegrador.semCelular.ISEMCelular;
import tpIntegrador.semCentral.SEMCentral;
import tpIntegrador.semCompra.ISEMCompra;
import tpIntegrador.semControl.ISEMControl;
import tpIntegrador.semEstacionamiento.ISEMEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.ISEMSistemaDeAsistencia;
import tpIntegrador.semZona.ISEMZona;

class SEMCentralTest {
    //SUT
	private SEMCentral semCentral;
	//DOC
	private ISEMCelular semCelular;
	private ISEMZona semZona;
	private ISEMSistemaDeAsistencia semSistemaDeAsistencia;
	private ISEMEstacionamiento semEstacionamiento;
	private ISEMCompra semCompra;
	private ISEMControl semControl;
	
	@BeforeEach
	public void setUp() {
	
		semCelular = mock(ISEMCelular.class);
		semZona = mock(ISEMZona.class);
		semSistemaDeAsistencia = mock(ISEMSistemaDeAsistencia.class);
		semEstacionamiento = mock(ISEMEstacionamiento.class);
		semCompra = mock(ISEMCompra.class);
		semControl = mock(ISEMControl.class);
		
		semCentral = new SEMCentral(semCelular, semZona, semSistemaDeAsistencia,
				                    semEstacionamiento, semCompra, semControl);
	}
	
	@Test
	void testConstructor() {
		assertEquals(semCelular, semCentral.getSemCelular());
		assertEquals(semZona, semCentral.getSemZona());
		assertEquals(semSistemaDeAsistencia, semCentral.getSemSistemaDeAsistencia());
		assertEquals(semEstacionamiento, semCentral.getSemEstacionamiento());
		assertEquals(semCompra, semCentral.getSemCompra());
		assertEquals(semControl, semCentral.getSemControl());
	}

}
