package TPIntegrador;

import java.time.LocalDate;

public class Comprobante {

	private LocalDate horaInicio;
	private LocalDate horaFin;
	private Integer nroControl;
	private PuntoDeVenta puntoDeVenta; //(?
	private LocalDate fecha;
	private LocalDate hora;
	
	public Comprobante(Integer numeroControl) {
		this.horaInicio = ;
		this.horaFin = ;
		this.nroControl = numeroControl;
		this.fecha = ;
		this.hora = ;
	    ////// puntoDeVenta (?
	}
	
	public LocalDate getHoraInicio() {
		return horaInicio;
	}

	public LocalDate getHoraFin() {
		return horaFin;
	}

	public Integer getNroControl() {
		return nroControl;
	}

	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalDate getHora() {
		return hora;
	}

}
