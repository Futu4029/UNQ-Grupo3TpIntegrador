package test.TPIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import tpIntegrador.*;


class CompraPuntualTest {
	private CompraPuntual sut;
	
	
	@BeforeEach
	void setUp() {
		sut = new CompraPuntual(6);
	}
	
	@Test
	void horasHabilitadas() {
		assertEquals(6, sut.getHorasHabilitadas());
	}
	
	@Test
	void generarComprobante() {
		SEM sem = mock(SEM.class);
		Comprobante comprobante = mock(Comprobante.class);
		sut.generarComprobante();
		verify(sem).registrarCompra(comprobante);
	}

}
