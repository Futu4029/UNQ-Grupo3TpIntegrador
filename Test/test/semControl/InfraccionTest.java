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
	private String patente2;
	private String inspector;
	private String inspector2;
	private Zona zona;
	private Zona zona2;
	private LocalDate fecha;
	private LocalTime hora;

	@BeforeEach
	void setUp() throws Exception {
		patente = "AZ0Y";
		patente2 = "BD23";
		inspector = "Pepe";
		inspector = "Pepito";
		zona = mock(Zona.class);
		zona2 = mock(Zona.class);
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
	
	@Test
	void testPodemosManipularLosDatosDeUnaInfraccion() {
		infraccion.setPatente(patente2);
		infraccion.setInspector(inspector2);
		infraccion.setZona(zona2);
		infraccion.setFecha(fecha);
		infraccion.setHora(hora);
		
		assertEquals(patente2, infraccion.getPatente());
		assertEquals(inspector2, infraccion.getInspector());
		assertEquals(zona2, infraccion.getZona());
		assertEquals(fecha, infraccion.getFecha());
		assertEquals(hora, infraccion.getHora());
	}

}
