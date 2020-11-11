package test.semCompra;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCompra.CompraVirtual;
import tpIntegrador.semZona.PuntoDeVenta;

import static org.mockito.Mockito.mock;

class CompraDeCreditoTest {

	private CompraVirtual compra;
	private PuntoDeVenta puntoDeVenta;
	
	@BeforeEach
	public void setUp() {
		puntoDeVenta = mock(PuntoDeVenta.class);
		compra = new CompraVirtual(puntoDeVenta, 200, "1122334455");
	}
	
	@Test
	void testConstructor() {
		assertEquals(200, compra.getMonto());
		assertEquals("punto12", compra.getPuntoDeVenta());
		assertEquals("1122334455", compra.getNumeroCelular());
	}

}
