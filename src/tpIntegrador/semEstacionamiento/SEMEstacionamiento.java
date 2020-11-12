package tpIntegrador.semEstacionamiento;

import java.time.LocalTime;
import java.util.ArrayList;

import tpIntegrador.estacionamiento.Estacionamiento;
import tpIntegrador.estacionamiento.EstacionamientoPuntual;
import tpIntegrador.estacionamiento.EstacionamientoVirtual;
import tpIntegrador.semCelular.ISEMCelular;
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
	float precioPorHora;
	
	public SEMEstacionamiento (ISEMCelular semCelular, ISEMZona semZona, 
							   ISEMSistemaDeAsistencia semSistemaDeAsistencia, long precioPorHora){
		this.setHoraInicioFranja(LocalTime.of(07,00));
		this.setHoraFinalFranja(LocalTime.of(20,00));
		estacionamientos = new ArrayList<Estacionamiento>();
		this.setSemCelular(semCelular);
		this.setSemZona(semZona);
		this.setSemSistemaDeAsistencia(semSistemaDeAsistencia);
		this.setPrecioPorHora(precioPorHora);
	}
	//getters y setters
	public ArrayList<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}

	public LocalTime getHoraInicioFranja() {
		return this.horaInicioFranja;
	}

	public LocalTime getHoraFinalFranja() {
		return this.horaFinalFranja;
	}

	public ISEMCelular getSemCelular() {
		return this.semCelular;
	}

	public ISEMZona getSemZona() {
		return this.semZona;
	}

	public ISEMSistemaDeAsistencia getSemSistemaDeAsistencia() {
		return this.semSistemaDeAsistencia;
	}

	public float getPrecioPorHora() {
		return this.precioPorHora;
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
	
	public void generarEstacionamientoPuntual(String patente, Integer cantHoras) {
		LocalTime horaFinal = LocalTime.now().plusHours(cantHoras);
		if(this.estaEnFranjaHoraria(horaFinal)) {
			this.registrar(new EstacionamientoPuntual(patente, horaFinal, cantHoras));
		}else {
			horaFinal = this.getHoraFinalFranja();
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
	
	public float precioPorMinuto() {
		return this.getPrecioPorHora()/60;
	}
	
	public float minutosDisponibles(float saldo, float precioPorMinuto) {
		return saldo / precioPorMinuto;
	}
	
	public LocalTime definirHoraMaxima(float creditoDisponible, LocalTime horarioDeInicio) {
		float minutosDisponibles = this.minutosDisponibles(creditoDisponible, this.precioPorMinuto());
		long minutos = (long) minutosDisponibles;
		LocalTime respuesta = horarioDeInicio.plusMinutes(minutos);
		return (this.estaEnFranjaHoraria(respuesta)) ? respuesta : this.getHoraFinalFranja();
	}
	
	public Notificacion finEstacionamiento(String celular) {
		LocalTime horaFin = LocalTime.now();
		Estacionamiento e = this.buscarEstacionamientoVigente(celular);
		e.finalizar(horaFin);
		long minutosConsumidos = this.minutosConsumidos(e.getHoraInicio(), e.getHoraFinal()); 
		LocalTime horasTotal = this.calculoHorasTotal(minutosConsumidos);
		float costo = minutosConsumidos * this.precioPorMinuto();
		this.getSemCelular().descontarCredito(celular, costo);
		return new NotificacionFinEstacionamiento(e.getHoraInicio(), e.getHoraFinal(), horasTotal, costo);
	}
	
	public long minutosConsumidos(LocalTime horaInicio, LocalTime horaFinal) {
		return (horaFinal.toSecondOfDay() - horaInicio.toSecondOfDay())/60;
	}
	
	public LocalTime calculoHorasTotal(long minutosConsumidos) {
		LocalTime respuesta = LocalTime.of(00, 00); 
		return respuesta.plusMinutes(minutosConsumidos);
	}
	
	
	public boolean estaEnFranjaHoraria(LocalTime horaInicio) {
		return horaInicio.isAfter(horaInicioFranja) && horaInicio.isBefore(horaFinalFranja);
	}
	
	public boolean estaVigentePatente(String patente) {
		return this.getEstacionamientos().stream().anyMatch(e -> e.estaVigente() && e.sonPatentesIguales(patente));
	}
	
	public boolean estaVigenteCelular(String celular) {
		return this.getEstacionamientos().stream().anyMatch(e -> e.estaVigente() && e.sonNumerosIguales(celular));
	}
	
	public Estacionamiento buscarEstacionamientoVigente(String celular) {
		return this.getEstacionamientos().stream().filter(e -> e.estaVigente() && e.sonNumerosIguales(celular)).findAny().get();
	}
	
	public void finalizarTodosEstacionamientos() {
		for(Estacionamiento e: this.getEstacionamientos()) {
			if(e.estaVigente()) {
			e.finalizar(this.getHoraFinalFranja());
			}
		}
	}
}
