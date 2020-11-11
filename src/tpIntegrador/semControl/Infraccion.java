package tpIntegrador.semControl;

import java.time.LocalDate;
import java.time.LocalTime;

import tpIntegrador.semZona.*;

public class Infraccion {

	private String patente;
	private LocalDate fecha;
	private LocalTime hora;
	private String inspector;
	private Zona zona;
	
	public Infraccion(String patente, LocalDate fecha, LocalTime hora, String inspector, Zona zona) {
		this.patente = patente;
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
		this.zona = zona;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

}