package test.semZonaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

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
	void setPuntosDeVentaTest() {
		ArrayList<String> puntosDeVenta = new ArrayList<String>();
		sut.setPuntosDeVenta(puntosDeVenta);
		assertEquals(puntosDeVenta, sut.getPuntosDeVenta());
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
	
	
	@Test
	void setInspectorTest() {
		// el que estaba seteaedo en el setup era Ricardo
		sut.setInspector("René");
		assertEquals("René", sut.getInspector());
	}
	
	@Test
	void getPoligonoTest() {
		ArrayList<IPuntoGeografico> puntosGeograficos = new ArrayList<IPuntoGeografico>();
		sut.setPuntosGeograficos(puntosGeograficos);
		assertEquals(puntosGeograficos, sut.getPuntosGeograficos());
	}
	
}
