package tpIntegrador.semSistemaDeAsistencia.notificacion;

public class NotificacionConsultaCredito extends Notificacion{
	float saldoDisponible;
	
	public NotificacionConsultaCredito(float saldoDisponible) {
		super();
		this.saldoDisponible = saldoDisponible;
	}
	
	public String imprimir() {
		return  "Ud tiene "+this.saldoDisponible+" pesos en credito disponible.";
	}
}
