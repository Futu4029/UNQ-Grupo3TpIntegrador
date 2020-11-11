package tpIntegrador.semCompra;

import tpIntegrador.semZona.PuntoDeVenta;

public class CompraDeCredito extends Compra{

	private float monto;
	private String numeroCelular;
	
	public CompraDeCredito(PuntoDeVenta puntoDeVenta, float monto, String nroCelular) {
		super(puntoDeVenta);
		this.monto = monto;
		this.numeroCelular = nroCelular;
	}

	public float getMonto() {
		return monto;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}
	
}
