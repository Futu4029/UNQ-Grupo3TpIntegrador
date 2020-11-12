package tpIntegrador.appEstacionamiento;

import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionAlertaFinalizarEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionAlertaIniciarEstacionamiento;

public class AlertaActivada implements ModoAlerta {

	public AlertaActivada() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String comenzoACaminar() {
		return new NotificacionAlertaIniciarEstacionamiento().imprimir();
	}

	@Override
	public String comenzoAManejar() {
		return new NotificacionAlertaFinalizarEstacionamiento().imprimir();
	}
}
