package tpIntegrador.estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	private String patente;
	
	public Estacionamiento(String patente, LocalTime horaFinal) {
		super();
		this.setPatente(patente);
		this.setHoraInicio(LocalTime.now());
		this.setHoraFinal(horaFinal);
	}
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean sonPatentesIguales(String patente) {
		return this.patente == patente;
	}

	public abstract boolean estaVigente();
	public abstract String getCelular();
	public abstract boolean sonNumerosIguales(String nroCelu);

}