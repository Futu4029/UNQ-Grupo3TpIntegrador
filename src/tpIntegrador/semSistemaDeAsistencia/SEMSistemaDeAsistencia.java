package tpIntegrador.semSistemaDeAsistencia;

import java.util.ArrayList;

import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;

public class SEMSistemaDeAsistencia implements ISEMSistemaDeAsistencia{
	private ArrayList<IObserver> observers;
	
	public SEMSistemaDeAsistencia() {
		this.observers = new ArrayList<IObserver>();
	}
	
	public void suscribir(IObserver o) {
		this.getObservers().add(o);
	}
	
	public void desuscribir(IObserver o) {
		this.getObservers().remove(o);
	}
	
	public void notificar(Notificacion n) {
		for(IObserver ob: this.getObservers()) {
			ob.update(n.imprimir());
		}
	}

	public ArrayList<IObserver> getObservers(){
		return this.observers;
	}
}
