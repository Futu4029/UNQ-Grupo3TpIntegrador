package test.semCompra;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCompra.CompraPorCredito;

class CompraPorCreditoTest {

	private CompraPorCredito recarga;
	
	@BeforeEach
	public void setUp() {
		recarga = new CompraPorCredito("punto12", 200, "1122334455");
	}
	
	@Test
	void testConstructor() {
		assertEquals(200, recarga.getMonto());
		assertEquals("punto12", recarga.getPuntoDeVenta());
		assertEquals("1122334455", recarga.getNumeroCelular());
	}

}
