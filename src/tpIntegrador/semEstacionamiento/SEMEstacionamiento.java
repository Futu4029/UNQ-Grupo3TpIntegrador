package tpIntegrador.semEstacionamiento;

import java.time.LocalTime;
import java.util.ArrayList;

import tpIntegrador.celular.ISEMCelular;
import tpIntegrador.estacionamiento.Estacionamiento;
import tpIntegrador.estacionamiento.EstacionamientoPuntual;
import tpIntegrador.semSistemaDeAsistencia.ISEMSistemaDeAsistencia;
import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionFinEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionInicioEstacionamiento;
import tpIntegrador.semZona.ISEMZona;

public class SEMEstacionamiento {
	ArrayList<Estacionamiento> estacionamientos;
	LocalTime horaInicioFranja;
	LocalTime horaFinalFranja;
	ISEMCelular semCelular;
	ISEMZona semZona;
	ISEMSistemaDeAsistencia semSistemaDeAsistencia;
	float precioPorHora;
	
	public SEMEstacionamiento (ISEMCelular semCelular, ISEMZona semZona, 
							   ISEMSistemaDeAsistencia semSistemaDeAsistencia, float precioPorHora){
		LocalTime horaInicioFranja = LocalTime.of(07,00);
		LocalTime horaFinalFranja = LocalTime.of(20,00);
		estacionamientos = new ArrayList<Estacionamiento>();
		this.semCelular = semCelular;
		this.semZona = semZona;
		this.semSistemaDeAsistencia = semSistemaDeAsistencia;
		this.precioPorHora = precioPorHora;
	}
	//getters y setters
	public ArrayList<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	public LocalTime getHoraInicioFranja() {
		return horaInicioFranja;
	}

	public LocalTime getHoraFinalFranja() {
		return horaFinalFranja;
	}

	public ISEMCelular getSemCelular() {
		return semCelular;
	}

	public ISEMZona getSemZona() {
		return semZona;
	}

	public ISEMSistemaDeAsistencia getSemSistemaDeAsistencia() {
		return semSistemaDeAsistencia;
	}

	public float getPrecioPorHora() {
		return precioPorHora;
	}

	public void setEstacionamientos(ArrayList<Estacionamiento> estacionamientos) {
		this.estacionamientos = estacionamientos;
	}

	public void setHoraInicioFranja(LocalTime horaInicioFranja) {
		this.horaInicioFranja = horaInicioFranja;
	}

	public void setHoraFinalFranja(LocalTime horaFinalFranja) {
		this.horaFinalFranja = horaFinalFranja;
	}

	public void setSemCelular(ISEMCelular semCelular) {
		this.semCelular = semCelular;
	}

	public void setSemZona(ISEMZona semZona) {
		this.semZona = semZona;
	}

	public void setSemSistemaDeAsistencia(ISEMSistemaDeAsistencia semSistemaDeAsistencia) {
		this.semSistemaDeAsistencia = semSistemaDeAsistencia;
	}

	public void setPrecioPorHora(float precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	
	public void registrar(Estacionamiento e) {
		this.getEstacionamientos().add(e);
	}
	
	public void generarCompraPuntual(String patente, Integer cantHoras) {
		LocalTime horaFinal = LocalTime.now().plusHours(cantHoras);
		if(this.estaEnFranjaHoraria(horaFinal)) {
			EstacionamientoPuntual e = new EstacionamientoPuntual(patente, horaFinal, cantHoras);
			this.registrar(e);
		}else {
			horaFinal = LocalTime.of(20, 00);
			EstacionamientoPuntual e = new EstacionamientoPuntual(patente, horaFinal, cantHoras);
			this.registrar(e);
		}
	}
	
	public Notificacion inicioEstacionamiento(String patente, String celular) {
		return new NotificacionInicioEstacionamiento(horaInicio, horaMaxima);
	}
	
	public Notificacion finEstacionamiento(String celular) {
		return new NotificacionFinEstacionamiento(horaInicio, horaFin, horasTotal, costo);
	}
	
	public boolean estaEnFranjaHoraria(LocalTime horaInicio) {
		return horaInicio.isAfter(horaInicioFranja) && horaInicio.isBefore(horaFinalFranja);
	}
	
	public boolean estaVigentePatente(String patente) {
		return this.getEstacionamientos().stream().anyMatch(e -> e.sonPatentesIguales(patente) && e.estaVigente());
	}
	
	public boolean estaVigenteCelular(String celular) {
		return this.getEstacionamientos().stream().anyMatch(e -> e.sonNumerosIguales(celular) && e.estaVigente());
	}
	
	public Estacionamiento buscarEstacionamientoVigente(String celular) {
		return this.getEstacionamientos().stream().filter(e -> e.sonNumerosIguales(celular) && e.estaVigente()).findAny().get();
	}
}
