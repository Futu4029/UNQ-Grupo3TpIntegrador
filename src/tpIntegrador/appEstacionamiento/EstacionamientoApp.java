package tpIntegrador.appEstacionamiento;

import tpIntegrador.semEstacionamiento.*;
import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;

public class EstacionamientoApp implements MovementSensor{
	
	private SEMEstacionamiento sem;
	private String celular;
	private String patente;
	private ModoApp modo;
	private ModoAlerta alerta;
	private EstadoMovimiento estadoMovimiento;
	
	public EstacionamientoApp(SEMEstacionamiento sem ,String patente, String celular, ModoApp modo, ModoAlerta alerta, EstadoMovimiento estadoMovimiento) {
		this.sem = sem;
		this.celular = celular;
		this.patente = patente;
		this.modo = modo;
		this.alerta = alerta;
		this.estadoMovimiento = estadoMovimiento;
	}
	
	//GETTERS AND SETTERS
	
	public SEMEstacionamiento getSem() {
		return sem;
	}
	
	public void setSem(SEMEstacionamiento sem) {
		this.sem = sem;
	}
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}


	public ModoApp getModo() {
		return modo;
	}


	public void setModo(ModoApp modo) {
		this.modo = modo;
	}


	public ModoAlerta getAlerta() {
		return alerta;
	}


	public void setAlerta(ModoAlerta alerta) {
		this.alerta = alerta;
	}


	public EstadoMovimiento getEstadoMovimiento() {
		return estadoMovimiento;
	}


	//METHODS
	
	public Notificacion inicioEstacionamiento(String patente, String celular) { 
		//se envia el mensaje de inicio a SEM
		return sem.inicioEstacionamiento(patente, celular);
	}
	
	public Notificacion finEstacionamiento(String celular) {
		// se envia el mensaje a sem para que finalice el estacionamiento
		return sem.finEstacionamiento(celular);
	}


	public void setEstadoMovimiento(EstadoMovimiento estado) {
		this.estadoMovimiento = estado;
	}

	public void comenzoAManejar() {
		//agregar if con condicion de si el estacionamiento es vigente
		this.alerta.comenzoAManejar();
		
		this.modo.comenzoAManejar(this, celular);

	}
	
	public void comenzoACaminar() {
		//agregar if con condicion de si el estacionamiento no es vigente
			this.alerta.comenzoACaminar();
		
			this.modo.comenzoACaminar(this, patente, celular);
	}


	@Override
	public void driving() {
		this.estadoMovimiento.manejando();
	}


	@Override
	public void walking() {
		this.estadoMovimiento.caminando();
	}

}
