package tpIntegrador.semCompra;

import tpIntegrador.semZona.PuntoDeVenta;

public class CompraVirtual extends Compra{

	private float monto;
	private String numeroCelular;
	
	public CompraVirtual(Integer nroControl, PuntoDeVenta puntoDeVenta, float monto, String nroCelular) {
		super(nroControl, puntoDeVenta);
		this.monto = monto;
		this.numeroCelular = nroCelular;
	}

	public float getMonto() {
		return this.monto;
	}

	public String getNumeroCelular() {
		return this.numeroCelular;
	}
	
}
