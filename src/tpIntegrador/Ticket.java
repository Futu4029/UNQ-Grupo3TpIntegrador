package tpIntegrador;

public class Ticket extends Comprobante {

	private Integer cantidadDeHoras;
	
	public Ticket(Integer nroControl, Integer horas) {
		super(nroControl);
		this.cantidadDeHoras = horas;
	}

	public Integer getCantidadDeHoras() {
		return cantidadDeHoras;
	}
	
}
