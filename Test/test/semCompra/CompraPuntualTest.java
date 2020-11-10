package test.semCompra;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCompra.CompraPuntual;

class CompraPuntualTest {

	private CompraPuntual compra;
	
	@BeforeEach
	public void setUp() {
		
        compra = new CompraPuntual("punto2", 5);
	}
	
	@Test
	void testConstructor() {
	    assertEquals(1, compra.getNroControl());
	    assertEquals("punto2", compra.getPuntoDeVenta());
	    assertEquals(5, compra.getCantidadDeHoras());
	}
}