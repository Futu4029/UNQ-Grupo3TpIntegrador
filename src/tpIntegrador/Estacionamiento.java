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
	
	public Estacionamiento() {
		super();
	}
	
	public boolean estaVigente() throws ParseException {
		String currentTime = LocalDate.now().toString();
		Date horaInicioFranja = new SimpleDateFormat("yyyy-MM-dd-HH:mm").parse("07:00");
		Date horaFinalFranja = new SimpleDateFormat("yyyy-MM-dd-HH:mm").parse("20:00");
		Date horaActual = new SimpleDateFormat("yyyy-MM-dd-HH:mm").parse(currentTime);
		return horaActual.after(horaInicioFranja) && horaActual.before(horaFinalFranja);
	}

	public float getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(float precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	
	


}