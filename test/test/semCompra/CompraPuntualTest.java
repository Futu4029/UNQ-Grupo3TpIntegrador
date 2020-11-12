package test.semCompra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import tpIntegrador.semCompra.CompraPuntual;
import tpIntegrador.semZona.PuntoDeVenta;

class CompraPuntualTest {
	private CompraPuntual compra;
	private PuntoDeVenta pVenta;
	
	@BeforeEach
	void setUp() {
		pVenta = mock(PuntoDeVenta.class);
		compra = new CompraPuntual(0, pVenta, 4);
		
	}
	
	@Test
	void constructorTest() {
		assertEquals(0, compra.getNroControl());
		assertEquals(pVenta, compra.getPuntoDeVenta());
		assertEquals(4, compra.getCantidadDeHoras());
	}

}
