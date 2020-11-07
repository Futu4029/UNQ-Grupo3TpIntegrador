package tpIntegrador;

import java.time.LocalDate;

public class Infraccion {

	private String patente;
	private LocalDate fecha;
	private LocalDate hora;
	private Inspector inspector;
	private Zona zona;
	
	public Infraccion(String patente, LocalDate fecha, LocalDate hora, Inspector inspector, Zona zona) {
		this.patente = patente;
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
		this.zona = zona;
	}

	public String getPatente() {
		return patente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalDate getHora() {
		return hora;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public Zona getZona() {
		return zona;
	}
}