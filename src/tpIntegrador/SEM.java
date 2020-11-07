package tpIntegrador;

import java.util.ArrayList;

public class SEM {

	private SEMRegistro registro;
	private ArrayList<Observer> observers;
	
	public SEM() {
		this.registro = new SEMRegistro();
		this.observers = .....;
	}
	
	public ArrayList<Observer> getObservers(){
		return observers;
	}
	
	public void consultarCredito(Celular celular) {
		
	}
	
	public void verificarVigencia(String patente) {
		
	}
	
	public void finalizarCompraVirtual(Celular celular) {
		
	}
	
	public void finalizarEstacionamientos() {
		
	}
	
	public void suscribir(Observer o) {
	}
	
	public void desuscribir(Observer o) {
	
	}
	
	public void registrarCompra(Comprobante c) {
		
	}
	
	public String generarInicioEstacionamiento(Celular celular, String s) {
		
	}
}