package test.semSistemaDeAsistencia;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionFinEstacionamiento;

class NotificacionFinEstacionamientoTest {
	Notificacion n;
	
	@BeforeEach
	void setUp() {
		n = new NotificacionFinEstacionamiento(LocalTime.of(14, 30),LocalTime.of(20, 00), LocalTime.of(06, 00), 20.00f);
		
		
	}
	@Test
	void imprimirTest() {
		assertEquals("Ha iniciado su estacionamiento a las 14:30. "
				   + "Su estacionamiento finalizó a las 20:00. "
				   + "Se ha debitado 20.0 pesos de su saldo por el total de 06:00 horas. "
				   + "Muchas Gracias", n.imprimir());
	}

}
