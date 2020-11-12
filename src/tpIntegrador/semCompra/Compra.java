package tpIntegrador.semCompra;

import java.time.LocalDate;
import java.time.LocalTime;

import tpIntegrador.semZona.PuntoDeVenta;

public class Compra {

	private Integer nroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDate fecha;
	private LocalTime hora;
	
	public Compra(Integer nroControl, PuntoDeVenta puntoDeVenta) {
		this.setNroControl(nroControl);
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = LocalDate.now(); 
		this.hora = LocalTime.now();
	}
	
	public Integer getNroControl() {
		return this.nroControl;
	}
	
	public void setNroControl(Integer nroControl) {
		this.nroControl = nroControl;
	}
	
	public PuntoDeVenta getPuntoDeVenta() {
		return this.puntoDeVenta;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public LocalTime getHora() {
		return this.hora;
	}
}