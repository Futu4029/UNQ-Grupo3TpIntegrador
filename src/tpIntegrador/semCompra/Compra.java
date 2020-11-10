package tpIntegrador.semCompra;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {

	private int nroControl;
	private String puntoDeVenta;
	private LocalDate fecha;
	private LocalTime hora;
	
	public Compra(String puntoDeVenta) {
		this.setNroControl(this.getNroControl() +1);
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = LocalDate.now(); 
		this.hora = LocalTime.now();
	}
	
	public int getNroControl() {
		return nroControl;
	}
	
	public void setNroControl(int nroControl) {
		this.nroControl = nroControl;
	}
	
	public String getPuntoDeVenta() {
		return puntoDeVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}
}