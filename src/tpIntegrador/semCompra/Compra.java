package tpIntegrador.semCompra;

import java.time.LocalDate;
import java.time.LocalTime;

import tpIntegrador.semZona.PuntoDeVenta;

public class Compra {

	private Integer nroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDate fecha;
	private LocalTime hora;
	
	public Compra(PuntoDeVenta puntoDeVenta, Integer nroControl) {
		this.setNroControl(nroControl);
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = LocalDate.now(); 
		this.hora = LocalTime.now();
	}
	
	public Integer getNroControl() {
		return nroControl;
	}
	
	public void setNroControl(Integer nroControl) {
		this.nroControl = nroControl;
	}
	
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}
}