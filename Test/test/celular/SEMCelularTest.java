package test.celular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import tpIntegrador.celular.Celular;
import tpIntegrador.celular.SEMCelular;

class SEMCelularTest {

	SEMCelular semCelular;
	Celular celular1;
	Celular celular2;
	Celular celular3;
	
	@BeforeEach
	public void setUp() {
		semCelular = new SEMCelular();
		celular1 = mock(Celular.class);
		celular2 = mock(Celular.class);
		celular3 = mock(Celular.class);
		
		when(this.celular1.getNumero()).thenReturn("1122334455");
		when(this.celular1.getCredito()).thenReturn(100f);
		
		when(this.celular2.getNumero()).thenReturn("5544332211");
		when(this.celular2.getCredito()).thenReturn(0f);
		
		when(this.celular3.getNumero()).thenReturn("6677889900");
		when(this.celular3.getCredito()).thenReturn(300f);
		
		semCelular.agregar(celular1.getNumero(), celular1.getCredito());
		semCelular.agregar(celular2.getNumero(), celular2.getCredito());
		semCelular.agregar(celular3.getNumero(), celular3.getCredito());
	}
	
	@Test
	void testConstructor() {
		assertEquals(3, semCelular.getCelulares().size());
	}
	
	@Test
	void consultarCreditoDeCelular3() {
		assertEquals(300, semCelular.consultarCredito("6677889900"));
	}
	
	@Test
	void recargarCreditoACelular2() {
		semCelular.recargar("5544332211", 150);
		assertEquals(150, semCelular.consultarCredito("5544332211"));
	}
	
	@Test
	void tieneCreditoSuficiente() {
		assertTrue(semCelular.tieneCreditoSuficiente("1122334455", 150));
	}
	
	@Test
	void noTieneCreditoSuficiente() {
		assertFalse(semCelular.tieneCreditoSuficiente("6677889900", 80));
	}

}