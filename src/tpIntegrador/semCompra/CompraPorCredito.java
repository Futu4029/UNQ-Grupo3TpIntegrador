package tpIntegrador.semCompra;

public class CompraPorCredito extends Compra{

	private Integer monto;
	private String numeroCelular;
	
	public CompraPorCredito(String puntoDeVenta, Integer monto, String nroCelular) {
		super(puntoDeVenta);
		this.monto = monto;
		this.numeroCelular = nroCelular;
	}

	public Integer getMonto() {
		return monto;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}
	
}
