package tpIntegrador.semCompra;

import tpIntegrador.semZona.PuntoDeVenta;

public class CompraPuntual extends Compra {

	private Integer cantidadDeHoras;
	
	public CompraPuntual(Integer nroControl, PuntoDeVenta puntoDeVenta, Integer horas) {
		super(nroControl, puntoDeVenta);
		this.cantidadDeHoras = horas;
	}

	public Integer getCantidadDeHoras() {
		return this.cantidadDeHoras;
	}
	
}