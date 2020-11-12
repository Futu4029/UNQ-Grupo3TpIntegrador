package test.semCompra;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.celular.SEMCelular;
import tpIntegrador.semCompra.Compra;
import tpIntegrador.semCompra.CompraVirtual;
import tpIntegrador.semCompra.CompraPuntual;
import tpIntegrador.semCompra.SEMCompra;
import tpIntegrador.semZona.PuntoDeVenta;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SEMCompraTest {

	private SEMCompra semCompra;
	private SEMCelular semCelular;
	private PuntoDeVenta puntoDeVenta;
	
	@BeforeEach
	public void setUp() {
		//DOC
		semCelular = mock(SEMCelular.class);
		//SUT
		semCompra = new SEMCompra(semCelular);
		//DOC
		puntoDeVenta = mock(PuntoDeVenta.class);
	}
	
	@Test
	void testConstructor() {
		assertEquals(0, semCompra.getCompras().size());
		assertEquals(0, semCompra.getNroControl());
		assertEquals(0, semCompra.getSemCelular());
	}
	
	@Test
	void contieneCompra() {
		Compra compra = mock(CompraPuntual.class);
		semCompra.registrar(compra);
		assertEquals(1, semCompra.getCompras().size());
		assertTrue(semCompra.contieneCompra(compra));
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
		semCompra.generarCompraPuntual(5, puntoDeVenta);
		assertEquals(1, semCompra.getCompras().size());	
	}

	@Test
	void testCompraCredito() {

		when(semCelular.consultarCredito("1122334455")).thenReturn(150f);
		
		semCompra.comprarCredito("1122334455", 150, puntoDeVenta);
		assertEquals(1, semCompra.getCompras().size());	
		assertEquals(150, semCelular.consultarCredito("1122334455"));
	}
}
