package test.semSistemaDeAsistencia;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionInicioEstacionamiento;

class NotificacionInicioEstacionamientoTest {
	NotificacionInicioEstacionamiento n;
	
	@BeforeEach
	void setUp() {
		n = new NotificacionInicioEstacionamiento(LocalTime.of(14, 30),LocalTime.of(20, 00));
		
	}
	@Test
	void imprimirTest() {
		assertEquals("Ha iniciado su estacionamiento a las 14:30. "
				   + "Su estacionamiento finaliza a las 20:00.", n.imprimir());
	}

}
