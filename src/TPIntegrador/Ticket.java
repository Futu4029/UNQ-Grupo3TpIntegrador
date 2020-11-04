package TPIntegrador;

public class Ticket extends Comprobante {

	private Integer cantidadDeHoras;
	
	public Ticket(Integer nroControl, Integer horas) {
	    this.cantidadDeHoras = horas;
		super(nroControl);
	}

}
