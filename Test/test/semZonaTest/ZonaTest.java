package test.semZonaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semZona.*;

class ZonaTest {
	Zona sut;
	IPuntoGeografico pg;

	@BeforeEach
	void setUp() {
		sut = new Zona("Ricardo");
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
		ArrayList<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
		sut.setPuntosDeVenta(puntosDeVenta);
		assertEquals(puntosDeVenta, sut.getPuntosDeVenta());
	}
	
	@Test
	void getPuntosGeograficosTest() {
		assertEquals(0, sut.getPuntosGeograficos().size());
	}
	
	@Test
	void registrarPuntoDeVentaTest() {
		pg = mock(IPuntoGeografico.class);
		PuntoDeVenta puntoV = mock(PuntoDeVenta.class);
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
		pg = mock(IPuntoGeografico.class);
		PuntoDeVenta puntoV = mock(PuntoDeVenta.class);
		sut.registrarPuntoDeVenta(puntoV);
		assertTrue(sut.contienePuntoDeVenta(puntoV));
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
