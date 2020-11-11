package tpIntegrador.semZona;

import tpIntegrador.semCompra.SEMCompra;
import tpIntegrador.semEstacionamiento.SEMEstacionamiento;

public class PuntoDeVenta {
	
	private SEMCompra semCompra;
	private SEMEstacionamiento semEstacionamiento;

	
	public PuntoDeVenta(SEMCompra semCompra, SEMEstacionamiento semEstacionamiento) {
		this.semCompra = semCompra;
		this.semEstacionamiento= semEstacionamiento;
	}

	//@Override
	public void generarCompraPuntual(Integer cantHoras, String patente) {
		semCompra.generarCompraPuntual(cantHoras, this);
		semEstacionamiento.generarEstacionamientoPuntual(patente, cantHoras);
	}

	//@Override
	public void generarRecargaDeCredito(String nroCelular, float monto) {
		semCompra.comprarCredito(nroCelular, monto, this);
	}
}
