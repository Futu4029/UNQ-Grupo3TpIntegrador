package test.semControl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.Zona;
import tpIntegrador.semControl.Infraccion;

class InfraccionTest {
	
	private Infraccion infraccion;
	private String patente;
	private String inspector;
	private Zona zona;
	private LocalDate fecha;
	private LocalTime hora;

	@BeforeEach
	void setUp() throws Exception {
		patente = "AZ0Y";
		inspector = "Gorrudo";
		zona = mock(Zona.class);
		fecha = LocalDate.now();
		hora = LocalTime.now();
		infraccion = new Infraccion(patente, fecha, hora, inspector, zona);
	}

	@Test
	void testPodemosConocerLaInformacionDeUnaInfraccion() {
		assertEquals(patente, infraccion.getPatente());
		assertEquals(inspector, infraccion.getInspector());
		assertEquals(zona, infraccion.getZona());
		assertEquals(fecha, infraccion.getFecha());
		assertEquals(hora, infraccion.getHora());
	}

}
