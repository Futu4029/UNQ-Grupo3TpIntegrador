package test.appEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import tpIntegrador.appEstacionamiento.CompraVirtual;
import tpIntegrador.appEstacionamiento.EstadoMovimiento;
import tpIntegrador.appEstacionamiento.ModoAlerta;
import tpIntegrador.appEstacionamiento.ModoApp;

class CompraVirtualTest {
	private CompraVirtual app; 
	private String celular;
	private String patente;
	private EstadoMovimiento estado;
	private ModoApp modoApp;
	private ModoAlerta modoAlerta; 
	


	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
