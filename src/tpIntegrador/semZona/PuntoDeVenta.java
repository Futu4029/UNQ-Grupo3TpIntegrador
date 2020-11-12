package tpIntegrador.semZona;

import tpIntegrador.semCompra.ISEMCompra;
import tpIntegrador.semEstacionamiento.ISEMEstacionamiento;

public class PuntoDeVenta {
	
	private ISEMCompra semCompra;
	private ISEMEstacionamiento semEstacionamiento;

	public PuntoDeVenta(ISEMCompra semCompra, ISEMEstacionamiento semEstacionamiento) {
		this.semCompra = semCompra;
		this.semEstacionamiento= semEstacionamiento;
	}

	public ISEMCompra getSemCompra() {
		return semCompra;
	}

	public ISEMEstacionamiento getSemEstacionamiento() {
		return semEstacionamiento;
	}

	public void generarCompraPuntual(Integer cantHoras, String patente) {
		this.getSemCompra().generarCompraPuntual(cantHoras, this);
		this.getSemEstacionamiento().generarEstacionamientoPuntual(patente, cantHoras);

	}

	public void generarRecargaDeCredito(String nroCelular, float monto) {
		this.getSemCompra().comprarCredito(nroCelular, monto, this);
	}
}
