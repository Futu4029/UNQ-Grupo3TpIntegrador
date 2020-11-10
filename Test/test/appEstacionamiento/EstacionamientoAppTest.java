package test.appEstacionamiento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	void testPodemosManipularYObtenerInformacionDeEstacionamientoApp() {
		SEMEstacionamiento sem2 = mock(SEMEstacionamiento.class);
		int celular2 = 1551468925;
		String patente2 = "A10ZO";
		EstadoMovimiento estado2 = mock(EstadoMovimiento.class);
		ModoApp modo2 = mock(ModoApp.class);
		ModoAlerta alerta2 = mock(ModoAlerta.class);
		
		app.setCelular(celular2);
		app.setPatente(patente2);
		app.setSem(sem2);
		app.setAlerta(alerta2);
		app.setEstadoMovimiento(estado2);
		app.setModo(modo2);
		
		assertEquals(celular2, app.getCelular());
		assertEquals(patente2, app.getPatente());
		assertEquals(estado2, app.getEstadoMovimiento());
		assertEquals(modo2, app.getModo());
		assertEquals(alerta2, app.getAlerta());
		assertEquals(sem2, app.getSem());
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
	
	@Test 
	void testAlComenzarAManejarSeAlertaLaAccionYSeDelegaASuModo() {
		app.comenzoAManejar();
		
		verify(alerta).comenzoAManejar();
		verify(modo).comenzoAManejar(app, celular);
	}
	
	@Test
	void testAlComenzarACaminarSeAlertaLaAccionYSeDelegaASuModo() {
		app.comenzoACaminar();
		
		verify(alerta).comenzoACaminar();
		verify(modo).comenzoACaminar(app, patente, celular);
	}
}
