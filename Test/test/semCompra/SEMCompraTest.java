package test.semCompra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.celular.ISEMCelular;
import tpIntegrador.semCompra.Compra;
import tpIntegrador.semCompra.CompraVirtual;
import tpIntegrador.semCompra.CompraPuntual;
import tpIntegrador.semCompra.SEMCompra;

import static org.mockito.Mockito.mock;

class SEMCompraTest {

	private SEMCompra semCompra;
	private ISEMCelular semCelular;
	
	@BeforeEach
	public void setUp() {
		semCompra = new SEMCompra();
	}
	
	@Test
	void testConstructor() {
		assertEquals(0, semCompra.getCompras().size());
	}
	
	@Test
	void RegistrarCompraEnSuColeccion() {
		Compra compra1 = mock(CompraPuntual.class);
		Compra compra2 = mock(CompraVirtual.class);
		
		semCompra.registrar(compra1);
		assertEquals(1, semCompra.getCompras().size());
		
		semCompra.registrar(compra2);
		assertEquals(2, semCompra.getCompras().size());	
	}
	
	@Test
	void testGeneraCompraPuntual() {		
		semCompra.generarCompraPuntual(5);
		assertEquals(1, semCompra.getCompras().size());
		
		semCompra.comprarCredito("1122334455", 150);
		assertEquals(2, semCompra.getCompras().size());	
	}

}
