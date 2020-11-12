package test.semCompra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semCompra.Compra;
import tpIntegrador.semZona.PuntoDeVenta;

import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

class CompraTest {
    //SUT
	private Compra compra;
	//DOC
	private PuntoDeVenta puntoDeVenta;

	@BeforeEach
	public void setUp() {
		puntoDeVenta = mock(PuntoDeVenta.class);
		compra = new Compra(1, puntoDeVenta);
	}
	
	@Test
	void testGetters() {
		compra.setHora(LocalTime.of(07, 00));
		assertEquals(LocalDate.now(), compra.getFecha());
		
		assertEquals(07,(compra.getHora().getHour()));
	}

}
