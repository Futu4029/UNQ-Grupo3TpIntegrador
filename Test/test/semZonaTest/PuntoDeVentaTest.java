package test.semZonaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.celular.SEMCelular;
import tpIntegrador.semCompra.CompraPuntual;
import tpIntegrador.semCompra.SEMCompra;
import tpIntegrador.semEstacionamiento.SEMEstacionamiento;
import tpIntegrador.semZona.PuntoDeVenta;

import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class PuntoDeVentaTest {
    //SUT
	private PuntoDeVenta puntoDeVenta;
	//DOC
	private SEMCompra semCompra;
	private SEMEstacionamiento semEstacionamiento;
	private String patente;
	private SEMCelular semCelular;
	private CompraPuntual compra;
	
	@BeforeEach
	public void setUp() {
		
		patente = "ABD123";
		
		compra = mock(CompraPuntual.class);
		semCompra = mock(SEMCompra.class);
		semCelular = mock(SEMCelular.class);
		semEstacionamiento = mock(SEMEstacionamiento.class);
		puntoDeVenta = new PuntoDeVenta(semCompra, semEstacionamiento);
	}
		
	@Test
	void generaCompraPuntual() {	

		puntoDeVenta.generarCompraPuntual(5, "ABD123");

		verify(semCompra).registrar(any(CompraPuntual.class));
	}	
	
	@Test
	void generarRecargaDeCredito() {
		
		puntoDeVenta.generarRecargaDeCredito("1122334455", 150);
		
		assertTrue(semCelular.contieneRecargaRealizadaDe("1122334455"));
	}	
		
}
