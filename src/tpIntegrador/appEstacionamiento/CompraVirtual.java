package tpIntegrador.appEstacionamiento;

import tpIntegrador.ETicket;
import tpIntegrador.Estacionamiento;

public class CompraVirtual extends Estacionamiento implements MovementSensor{

	private Integer celular;
	private ModoApp modo;
	private ModoAlerta alerta;
	private EstadoMovimiento estadoMovimiento;
	
	public CompraVirtual(String patente, Integer celular, ModoApp modo, ModoAlerta alerta, EstadoMovimiento estadoMovimiento) {
		super(patente);
		this.celular = celular;
		this.modo = modo;
		this.alerta = alerta;
		this.estadoMovimiento = estadoMovimiento;
	}
	
	//GETTERS AND SETTERS
	
	public Integer getCelular() {
		return celular;
	}



	public void setCelular(Integer celular) {
		this.celular = celular;
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
		//implementar que genere un ticket y se cargue en estacionamientos
	}
	
	public void finEstacionamiento(Integer celular) {
		// implementar que se saque de estacionamientos 
	}


	public void setEstadoMovimiento(EstadoMovimiento estado) {
		this.estadoMovimiento = estado;
	}

	public void comenzoAManejar() {
		//agregar if con condicion de si el estacionamiento es vigente
		this.alerta.comenzoAManejar();
		
		this.modo.comenzoAManejar(this, getPatente(), celular);

	}
	
	public void comenzoACaminar() {
		//agregar if con condicion de si el estacionamiento no es vigente
			this.alerta.comenzoACaminar();
		
			this.modo.comenzoAManejar(this, getPatente(), celular);
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
