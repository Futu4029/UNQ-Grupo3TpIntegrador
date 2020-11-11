package tpIntegrador.estacionamiento;

import java.time.LocalTime;

public class EstacionamientoVirtual extends Estacionamiento{
	private String celular;
	private boolean estaVigente;

	public EstacionamientoVirtual(String patente, String celular, LocalTime horaMaxima) {
		super(patente, horaMaxima);
		this.celular = celular;
		this.setEstaVigente(true);
	}
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public boolean estaVigente() {
		return this.estaVigente;
	}
	
	public void finalizar() {
		this.setEstaVigente(false);
	}
	@Override
	public boolean sonNumerosIguales(String nroCelu) {
		return this.getCelular() == nroCelu;
	}

	public void setEstaVigente(boolean estaVigente) {
		this.estaVigente = estaVigente;
	}

}
