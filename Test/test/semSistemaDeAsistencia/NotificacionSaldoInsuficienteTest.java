package test.semSistemaDeAsistencia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionSaldoInsuficiente;

class NotificacionSaldoInsuficienteTest {
	NotificacionSaldoInsuficiente n;
	
	@BeforeEach
	void setUp() {
		n = new NotificacionSaldoInsuficiente();
		
	}
	@Test
	void imprimirTest() {
		assertEquals("Saldo insuficiente. Estacionamiento no permitido.", n.imprimir());
	}

}
