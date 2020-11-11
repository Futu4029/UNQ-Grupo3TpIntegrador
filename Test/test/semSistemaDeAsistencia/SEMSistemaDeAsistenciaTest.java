package test.semSistemaDeAsistencia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import tpIntegrador.semSistemaDeAsistencia.IObserver;
import tpIntegrador.semSistemaDeAsistencia.SEMSistemaDeAsistencia;
import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;

class SEMSistemaDeAsistenciaTest {
	SEMSistemaDeAsistencia sem;
	
	@BeforeEach
	void setUp() {
		sem = new SEMSistemaDeAsistencia();
	}
	
	
	@Test
	void suscribirTest() {
		IObserver dummy = mock(IObserver.class);
		sem.suscribir(dummy);
		assertEquals(1, sem.getObservers().size());
	}
	
	@Test
	void desuscribirTest() {
		IObserver dummy = mock(IObserver.class);
		sem.suscribir(dummy);
		sem.desuscribir(dummy);
		assertEquals(0, sem.getObservers().size());
	}
	
	@Test
	void notificarTest() {
		//setup
		//DOC
		IObserver suscriptor= mock(IObserver.class);
		sem.suscribir(suscriptor);
		IObserver suscriptor2= mock(IObserver.class);
		sem.suscribir(suscriptor2);
		Notificacion mensaje = mock(Notificacion.class);
		when(mensaje.imprimir()).thenReturn("prueba");
		//exercise
		sem.notificar(mensaje);
		//assertion
		verify(suscriptor).update("prueba");
		verify(suscriptor2).update("prueba");
	}
}
