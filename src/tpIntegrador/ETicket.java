package tpIntegrador;

public class ETicket extends Comprobante{

	private Integer monto;
	private String numeroCelular;
	
	public ETicket(Integer nroControl, Integer monto, String celular) {
		super(nroControl);
		this.monto = monto;
		this.numeroCelular = celular;
	}

	public ETicket() {
		// TODO Auto-generated constructor stub
	}

	public Integer getMonto() {
		return monto;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}
	
}
