package tPIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import tpIntegrador.*;

public class EstacionamientoTest {
	private Estacionamiento est;
	private CompraPuntualTest cp;
	
	@BeforeEach
	public void setUp() {
		est = new Estacionamiento();
		cp = new CompraPuntualTest(6);
	}
	
	@Test
	void estaVigente() {
		assertTrue(cp.estaVigente());
	}
	
	@Test
	void comprobanteTest() {
		;
	}
}
