package tpIntegrador.semSistemaDeAsistencia.notificacion;

public class NotificacionSaldoInsuficiente extends Notificacion{

	@Override
	public String imprimir() {
		
		return  "Saldo insuficiente. Estacionamiento no permitido.";
	}
	

}
