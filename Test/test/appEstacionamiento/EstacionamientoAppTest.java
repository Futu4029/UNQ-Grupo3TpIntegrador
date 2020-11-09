package test.appEstacionamiento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import tpIntegrador.SEMEstacionamiento;
import tpIntegrador.appEstacionamiento.EstacionamientoApp;
import tpIntegrador.appEstacionamiento.EstadoMovimiento;
import tpIntegrador.appEstacionamiento.ModoAlerta;
import tpIntegrador.appEstacionamiento.ModoApp;

class EstacionamientoAppTest {
	private SEMEstacionamiento sem;
	private EstacionamientoApp app; 
	private Integer celular;
	private String patente;
	private EstadoMovimiento estado;
	private ModoApp modo;
	private ModoAlerta alerta; 
	


	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SEMEstacionamiento.class);
		celular = 1551468925;
		patente = "A10ZO";
		estado = mock(EstadoMovimiento.class);
		modo = mock(ModoApp.class);
		alerta = mock(ModoAlerta.class);
		app = new EstacionamientoApp(sem, patente, celular, modo, alerta, estado);
		
	}

	@Test
	void testAlIniciarEstacionamientoSeEnviaUnMensajeASem() {
		
		app.inicioEstacionamiento(patente, celular);
		
		verify(sem).inicioEstacionamiento(patente, celular);
	}
	
	@Test
	void testAlFinalizarEstacionamientoElMismoYaNoSeEncuentraRegistado() {
		
		app.finEstacionamiento(celular);
		
		verify(sem).finEstacionamiento(celular);
	}

	@Test
	void testAlRecibirMensajeDrivingEsteSeDelegaASusEstados() {
		
		app.driving();
		
		verify(estado).manejando();
	}
	
	@Test
	void testAlRecibirMensajeWalkingEsteSeDelegaASusEstados() {
		
		app.walking();
		
		verify(estado).caminando();
	}
}
