package test.semZonaTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCompra.SEMCompra;
import tpIntegrador.semEstacionamiento.SEMEstacionamiento;
import tpIntegrador.semZona.PuntoDeVenta;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PuntoDeVentaTest {
    //SUT
	private PuntoDeVenta puntoDeVenta;
	//DOC
	private SEMCompra semCompra;
	private SEMEstacionamiento semEstacionamiento;
	private String patente;
	
	@BeforeEach
	public void setUp() {
		patente = "ABD123";
		semCompra = mock(SEMCompra.class);
		semEstacionamiento = mock(SEMEstacionamiento.class);
		puntoDeVenta = new PuntoDeVenta(semCompra, semEstacionamiento);
	}
		
	@Test
	void generaCompraPuntual() {	
		puntoDeVenta.generarCompraPuntual(5, patente);
		verify(semCompra).generarCompraPuntual(5, puntoDeVenta);
		verify(semEstacionamiento).generarEstacionamientoPuntual(patente, 5);
	}	
	
	@Test
	void generarRecargaDeCredito() {
		puntoDeVenta.generarRecargaDeCredito("1122334455", 150f);
		verify(semCompra).comprarCredito("1122334455", 150f, puntoDeVenta);
	}	
		
}
