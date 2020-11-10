package tpIntegrador.appEstacionamiento;

import tpIntegrador.SEMEstacionamiento;

public class EstacionamientoApp implements MovementSensor{
	
	private SEMEstacionamiento sem;
	private Integer celular;
	private String patente;
	private ModoApp modo;
	private ModoAlerta alerta;
	private EstadoMovimiento estadoMovimiento;
	
	public EstacionamientoApp(SEMEstacionamiento sem ,String patente, Integer celular, ModoApp modo, ModoAlerta alerta, EstadoMovimiento estadoMovimiento) {
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
	
	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
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
	
	public void inicioEstacionamiento(String patente, Integer celular) { 
		//se envia el mensaje de inicio a SEM
		sem.inicioEstacionamiento(patente, celular);
	}
	
	public void finEstacionamiento(Integer celular) {
		// se envia el mensaje a sem para que finalice el estacionamiento
		sem.finEstacionamiento(celular);
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
