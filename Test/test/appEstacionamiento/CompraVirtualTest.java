package test.appEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import tpIntegrador.appEstacionamiento.CompraVirtual;
import tpIntegrador.appEstacionamiento.EstadoMovimiento;
import tpIntegrador.appEstacionamiento.ModoAlerta;
import tpIntegrador.appEstacionamiento.ModoApp;

class CompraVirtualTest {
	private CompraVirtual app; 
	private Integer celular;
	private String patente;
	private EstadoMovimiento estado;
	private ModoApp modo;
	private ModoAlerta alerta; 
	


	@BeforeEach
	void setUp() throws Exception {
		celular = 1551468925;
		patente = "A10ZO";
		estado = mock(EstadoMovimiento.class);
		modo = mock(ModoApp.class);
		alerta = mock(ModoAlerta.class);
		app = new CompraVirtual(patente, celular, modo, alerta, estado);
		
	}

	@Test
	void testAlIniciarEstacionamientoSeGeneraUnTicketYSeRegistraElMismo() {
		
		app.inicioEstacionamiento(patente, celular);
		
		fail("Not yet implemented");
	}
	
	@Test
	void testAlFinalizarEstacionamientoElMismoYaNoSeEncuentraRegistado() {
		
	}

	@Test
	void testAlRecibirMensajeDrivingEsteSeDelegaASusEstados() {
		
	}
}
