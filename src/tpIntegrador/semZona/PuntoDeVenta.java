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

	public SEMCompra getSemCompra() {
		return semCompra;
	}

	public SEMEstacionamiento getSemEstacionamiento() {
		return semEstacionamiento;
	}

	public void generarCompraPuntual(Integer cantHoras, String patente) {
		this.getSemCompra().generarCompraPuntual(cantHoras, this);
		this.getSemEstacionamiento().generarCompraPuntual(patente, cantHoras);
	}

	public void generarRecargaDeCredito(String nroCelular, float monto) {
		this.getSemCompra().comprarCredito(nroCelular, monto, this);
	}
}
