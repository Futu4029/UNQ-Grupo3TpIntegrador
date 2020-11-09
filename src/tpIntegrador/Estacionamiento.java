package tpIntegrador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;

public class Estacionamiento {

	private ArrayList<Estacionamiento> estacionamientos;
	private Date horaInicio;
	private Date horaFinal;
	protected float precioPorHora = 40;
	private Comprobante comprobante;
	private String patente;
	
	public Estacionamiento(String patente) {
		super();
		this.patente = patente;
	}
	
	public boolean estaVigente() throws ParseException {
		String currentTime = LocalDate.now().toString();
		Date horaInicioFranja = new SimpleDateFormat("yyyy-MM-dd-HH:mm").parse("07:00");
		Date horaFinalFranja = new SimpleDateFormat("yyyy-MM-dd-HH:mm").parse("20:00");
		Date horaActual = new SimpleDateFormat("yyyy-MM-dd-HH:mm").parse(currentTime);
		return horaActual.after(horaInicioFranja) && horaActual.before(horaFinalFranja);
	}

	public ArrayList<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	public void setEstacionamientos(ArrayList<Estacionamiento> estacionamientos) {
		this.estacionamientos = estacionamientos;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public float getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(float precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	
	


}