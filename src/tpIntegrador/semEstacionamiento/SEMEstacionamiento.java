package tpIntegrador.semEstacionamiento;

import java.time.LocalTime;
import java.util.ArrayList;

import tpIntegrador.celular.ISEMCelular;
import tpIntegrador.estacionamiento.Estacionamiento;
import tpIntegrador.estacionamiento.EstacionamientoPuntual;
import tpIntegrador.estacionamiento.EstacionamientoVirtual;
import tpIntegrador.semSistemaDeAsistencia.ISEMSistemaDeAsistencia;
import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionFinEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionInicioEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.notificacion.NotificacionSaldoInsuficiente;
import tpIntegrador.semZona.ISEMZona;

public class SEMEstacionamiento {
	ArrayList<Estacionamiento> estacionamientos;
	LocalTime horaInicioFranja;
	LocalTime horaFinalFranja;
	ISEMCelular semCelular;
	ISEMZona semZona;
	ISEMSistemaDeAsistencia semSistemaDeAsistencia;
	long precioPorHora;
	
	public SEMEstacionamiento (ISEMCelular semCelular, ISEMZona semZona, 
							   ISEMSistemaDeAsistencia semSistemaDeAsistencia, long precioPorHora){
		this.setHoraFinalFranja(LocalTime.of(07,00));
		this.setHoraFinalFranja(LocalTime.of(20,00));
		estacionamientos = new ArrayList<Estacionamiento>();
		this.setSemCelular(semCelular);
		this.setSemZona(semZona);
		this.setSemSistemaDeAsistencia(semSistemaDeAsistencia);
		this.setPrecioPorHora(precioPorHora);
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

	public long getPrecioPorHora() {
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

	public void setPrecioPorHora(long precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	
	public void registrar(Estacionamiento e) {
		this.getEstacionamientos().add(e);
	}
	
	public void generarEstacionamientoPuntual(String patente, Integer cantHoras) {
		LocalTime horaFinal = LocalTime.now().plusHours(cantHoras);
		if(this.estaEnFranjaHoraria(horaFinal)) {
			this.registrar(new EstacionamientoPuntual(patente, horaFinal, cantHoras));
		}else {
			horaFinal = LocalTime.of(20, 00);
			this.registrar(new EstacionamientoPuntual(patente, horaFinal, cantHoras));
		}
	}
	
	public Notificacion inicioEstacionamiento(String patente, String celular) {
		if(!(semCelular.tieneCreditoSuficiente(celular, this.precioPorMinuto()))){
			return new NotificacionSaldoInsuficiente();
		}else {
			LocalTime horaMaxima = this.definirHoraMaxima(semCelular.consultarCredito(celular), LocalTime.now());
			EstacionamientoVirtual e = new EstacionamientoVirtual(patente, celular, horaMaxima);
			this.registrar(e);
			return new NotificacionInicioEstacionamiento(e.getHoraInicio(), e.getHoraFinal());
		}
		
	}
	
	public long precioPorMinuto() {
		return this.getPrecioPorHora()/60;
	}
	
	public LocalTime definirHoraMaxima(float creditoDisponible, LocalTime horarioDeInicio) {
		long cd = (long) creditoDisponible;
		long minutosDisponibles = Math.multiplyExact(cd, this.precioPorMinuto());
		LocalTime respuesta = horarioDeInicio.plusMinutes(minutosDisponibles);
		return (this.estaEnFranjaHoraria(respuesta)) ? respuesta : this.getHoraFinalFranja();
	}
	
	public Notificacion finEstacionamiento(String celular) {
		LocalTime horaFin = LocalTime.now();
		Estacionamiento e = this.buscarEstacionamientoVigente(celular);
		e.finalizar(horaFin);
		long minutosConsumidos = (e.getHoraFinal().toSecondOfDay() - e.getHoraInicio().toSecondOfDay())*60; 
		LocalTime horasTotal = LocalTime.of(0, 0).plusMinutes(minutosConsumidos);
		float costo = minutosConsumidos * this.precioPorMinuto();
		return new NotificacionFinEstacionamiento(e.getHoraInicio(), horaFin, horasTotal, costo);
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
