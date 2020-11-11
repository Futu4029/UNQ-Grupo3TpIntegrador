package tpIntegrador.semZona;

import tpIntegrador.celular.SEMCelular;
import tpIntegrador.semCompra.SEMCompra;
import tpIntegrador.semEstacionamiento.SEMEstacionamiento;

public class PuntoDeVenta {
	
	private SEMCompra semCompra;
	private SEMEstacionamiento semEstacionamiento;

	
	public PuntoDeVenta(SEMCompra semCompra, SEMEstacionamiento semEstacionamiento, SEMCelular semCelular) {
		this.semCompra = semCompra;
		this.semEstacionamiento= semEstacionamiento;
	}

	//@Override
	public void generarCompraPuntual(Integer cantHoras, String patente) {
		semCompra.generarCompraPuntual(cantHoras, this);
		semEstacionamiento.generarCompraPuntual(patente, cantHoras);
	}

	//@Override
	public void generarRecargaDeCredito(String nroCelular, float monto) {
		semCompra.comprarCredito(nroCelular, monto, this);
	}
}
