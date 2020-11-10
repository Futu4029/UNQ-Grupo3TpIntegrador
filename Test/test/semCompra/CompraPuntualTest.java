package test.semCompra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCompra.CompraPuntual;
import tpIntegrador.semZona.PuntoDeVenta;

class CompraPuntualTest {

	private CompraPuntual compra;
	private PuntoDeVenta puntoDeVenta;
	
	@BeforeEach
	public void setUp() {
		
		puntoDeVenta = mock(PuntoDeVenta.class);
        compra = new CompraPuntual(puntoDeVenta, 5);
	}
	
	@Test
	void testConstructor() {
	    assertEquals(1, compra.getNroControl());
	    assertEquals(puntoDeVenta, compra.getPuntoDeVenta());
	    assertEquals(5, compra.getCantidadDeHoras());
	}
}