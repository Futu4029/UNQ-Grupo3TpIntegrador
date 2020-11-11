package tpIntegrador.semCompra;

import tpIntegrador.semZona.PuntoDeVenta;

public class CompraPuntual extends Compra {

	private Integer cantidadDeHoras;
	
	public CompraPuntual(PuntoDeVenta puntoDeVenta, Integer horas) {
		super(puntoDeVenta);
		this.cantidadDeHoras = horas;
	}

	public Integer getCantidadDeHoras() {
		return cantidadDeHoras;
	}
	
}