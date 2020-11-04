package TPIntegrador;

import java.time.LocalDate;

public class Estacionamiento {

	private Boolean estaVigente;
	private String patente;
	private LocalDate horaInicio;
	private LocalDate horaFinal;
	private float precioPorHora;
	private Comprobante comprobante;
	
	public Estacionamiento(String patente) {
		this.patente = patente;
		this.horaInicio = ;
		this.horaFinal = ;
		this.estaVigente = true;
        /////////////////
	}

	public Boolean getEstaVigente() {
		return estaVigente;
	}

	public String getPatente() {
		return patente;
	}

	public LocalDate getHoraInicio() {
		return horaInicio;
	}

	public LocalDate getHoraFinal() {
		return horaFinal;
	}
	
	public float getPrecioPorHora() {
		return precioPorHora;
	}
	
	public Comprobante getComprobante() {
		return comprobante;
	}
	
	public void generarComprobante() {
		
	}

	public void finDeEstacionamiento(String patente) {
		
	}
}