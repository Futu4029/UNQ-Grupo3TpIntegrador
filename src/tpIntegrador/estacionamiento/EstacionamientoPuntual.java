package tpIntegrador.estacionamiento;

import java.time.LocalTime;


public class EstacionamientoPuntual extends Estacionamiento{

	private Integer horasHabilitadas;
	
	public EstacionamientoPuntual(String patente, LocalTime horaFinal, Integer horas) {
		super(patente, horaFinal);
		this.setHorasHabilitadas(horas);
	}

	public int getHorasHabilitadas() {
		return horasHabilitadas;
	}

	public void setHorasHabilitadas(Integer horasHabilitadas) {
		this.horasHabilitadas = horasHabilitadas;
	}

	@Override
	public String getCelular() {
		return null;
	}

	@Override
	public boolean sonNumerosIguales(String nroCelu) {
		return false;
	}

	@Override
	public boolean estaVigente() {
		return this.getHoraFinal().isAfter(LocalTime.now());
	}

	
}
