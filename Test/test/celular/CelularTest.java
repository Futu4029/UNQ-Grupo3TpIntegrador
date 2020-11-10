package test.celular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.celular.Celular;

class CelularTest {

	Celular celular;
	
	@BeforeEach
	public void setUp() {
		celular = new Celular("1122334455");
	}
	
	@Test
	void testConstructor() {
		assertEquals("1122334455", celular.getNumero());
		assertEquals(0, celular.getCredito());
	}

}
