package test.semSistemaDeAsistencia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionConsultaCredito;


class NotificacionConsultaCreditoTest {
	NotificacionConsultaCredito n;
	
	@BeforeEach
	void setUp() {
		float saldoDisponible = 200.0f;
		n = new NotificacionConsultaCredito(saldoDisponible);
	}
	@Test
	void imprimirTest() {
		assertEquals("Ud tiene 200.0 pesos en credito disponible.", n.imprimir());
	}
}
