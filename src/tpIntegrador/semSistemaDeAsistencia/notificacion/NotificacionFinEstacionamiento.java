package tpIntegrador.semSistemaDeAsistencia.notificacion;

import java.time.LocalTime;

public class NotificacionFinEstacionamiento extends Notificacion{
	private LocalTime horaInicio;
	private LocalTime horaMaxima;
	private LocalTime horasTotal;
	private float costo;
	
	public NotificacionFinEstacionamiento(LocalTime horaInicio, LocalTime horaMaxima, LocalTime horasTotal,
			float costo) {
		super();
		this.horaInicio = horaInicio;
		this.horaMaxima = horaMaxima;
		this.horasTotal = horasTotal;
		this.costo = costo;
	}
	
	@Override
	public String imprimir() {
		return "Ha iniciado su estacionamiento a las "+this.horaInicio.toString()+
				". Su estacionamiento finalizó a las "+this.horaMaxima.toString()+
				". Se ha debitado "+this.costo+" pesos de su saldo por el total de "+
				this.horasTotal.toString()+" horas. Muchas Gracias";
	}

}