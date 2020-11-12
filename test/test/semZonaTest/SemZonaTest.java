package test.semZonaTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpIntegrador.semZona.*;

class SemZonaTest {
	SEMZona sut;
	Zona z1;
	IPuntoGeografico pg;

	@BeforeEach
	void setUp() {
		sut = new SEMZona();
		z1 = mock(Zona.class);
		pg = mock(IPuntoGeografico.class);
	}
	
	@Test
	void getZonasTest() {
		assertEquals(0, sut.getZonas().size());
	}
	
	@Test
	void registrarTest() {
		sut.registrar(z1);
		assertEquals(1, sut.getZonas().size());
	}
	
	@Test
	void perteneceAZonaTest() {
		sut.registrar(z1);
		when(z1.contienePuntoGeografico(pg)).thenReturn(true);
		assertTrue(sut.perteneceAZona(pg));
	}
	
}
