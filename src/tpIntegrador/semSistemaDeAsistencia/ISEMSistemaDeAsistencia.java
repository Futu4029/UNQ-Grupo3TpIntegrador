package tpIntegrador.semSistemaDeAsistencia;

import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;

public interface ISEMSistemaDeAsistencia {
	void suscribir(IObserver o);
	void desuscribir(IObserver o);
	void notificar(Notificacion n);
}
