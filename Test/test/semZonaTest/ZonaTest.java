package test.semZonaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semZona.IPuntoGeografico;
import tpIntegrador.semZona.Zona;

class ZonaTest {
	Zona sut;
	IPuntoGeografico pg;
	String puntoV;

	@BeforeEach
	void setUp() {
		sut = new Zona("Ricardo");
		pg = mock(IPuntoGeografico.class);
		puntoV = "MaxiKiosco";
		//Una interfaz no se implementa
		//pero suponemos que es una clase 
		//que implementa la interfaz
	}
	
	@Test
	void getInspectorTest() {
		assertEquals("Ricardo", sut.getInspector());
	}
	
	@Test
	void getPuntosDeVentaTest() {
		assertEquals(0, sut.getPuntosDeVenta().size());
	}
	
	@Test
	void getPuntosGeograficosTest() {
		assertEquals(0, sut.getPuntosGeograficos().size());
	}
	
	@Test
	void registrarPuntoDeVentaTest() {
		sut.registrarPuntoDeVenta(puntoV);
		assertEquals(1, sut.getPuntosDeVenta().size());
	}
	
	@Test
	void registrarPuntoGeograficoTest() {
		sut.registrarPuntoGeografico(pg);
		assertEquals(1, sut.getPuntosGeograficos().size());
	}
	
	@Test
	void contienePuntoDeVentaTest() {
		sut.registrarPuntoDeVenta(puntoV);
		assertTrue(sut.contienePuntoDeVenta("MaxiKiosco"));
	}
	
	@Test
	void contienePuntoGeograficoTest() {
		sut.registrarPuntoGeografico(pg);
		assertTrue(sut.contienePuntoGeografico(pg));
	}
}
