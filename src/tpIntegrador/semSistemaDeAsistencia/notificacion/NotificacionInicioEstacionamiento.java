package tpIntegrador.semSistemaDeAsistencia.notificacion;

import java.time.LocalTime;

public class NotificacionInicioEstacionamiento extends Notificacion{
	private LocalTime horaInicio;
	private LocalTime horaMaxima;
	
	public NotificacionInicioEstacionamiento(LocalTime horaInicio, LocalTime horaMaxima) {
		super();
		this.horaInicio = horaInicio;
		this.horaMaxima = horaMaxima;
	}


	@Override
	public String imprimir() {
		return "Ha iniciado su estacionamiento a las "+horaInicio.toString()+
				". Su estacionamiento finaliza a las "+horaMaxima.toString()+".";
	}

}
