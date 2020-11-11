package test.semZonaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCompra.CompraVirtual;
import tpIntegrador.semCompra.SEMCompra;
import tpIntegrador.semZona.PuntoDeVenta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PuntoDeVentaTest {

	private PuntoDeVenta puntoDeVenta;
	private SEMCompra semCompra;
	
	@BeforeEach
	public void setUp() {
		puntoDeVenta = new PuntoDeVenta(semCompra);
		semCompra = mock(SEMCompra.class);
	}
		
	@Test
	void generaCompraPuntual() {		
		puntoDeVenta.generarCompraPuntual(5);
    	assertEquals(1, semCompra.getCompras().size());
			
    	puntoDeVenta.comprarCredito("1122334455", 150);
		assertEquals(2, semCompra.getCompras().size());	
	}	
	
	@Test
	void recargarCredito() {
		puntoDeVenta.comprarCredito("1122334455", 150);
		
		verify(semCompra).registrar(any(CompraVirtual.class));
	}
}
