package TPIntegrador;

import java.util.ArrayList;

public class SEM {

	private Boolean estado;
	private ArrayList<String> patentes;
	private ArrayList<CallCenter> callCenters;   // ?)
	private ArrayList<Zona> zonas;
	private ArrayList<?> compras; /// (?
	private ArrayList<Estacionamiento> estacionamientos;
	private ArrayList< //(? )> creditosDisponibles;  ///   (?
	private ArrayList<Infraccion> infracciones;
	private ArrayList<AppGobierno > apps;  /// (?
	
	
	public SEM() {
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public ArrayList<String> getPatentes() {
		return patentes;
	}

	public ArrayList<CallCenter> getCallCenters() {
		return callCenters;
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public ArrayList< (? )> getCompras() {
		return compras;
	}

	public ArrayList<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}
	
	public ArrayList<Infraccion> getInfracciones() {
		return infracciones;
	}

	public ArrayList<AppGobierno> getApps() {
		return apps;
	}
	
	public void finalizarEstacionamiento() {
		
	}
	
	public void suscribir(CallCenter callCenter) {
		this.callCenters.add(callCenter);
	}
	
	public void desuscribir(CallCenter callCenter) {
		this.callCenters.remove(callCenter);
	}
	
	public void registrarCompra( (? ) {
		this.compras.add(compra);
	}
	
	public void registrarPatente(String patente) {
		this.patentes.add(patente);
	}
	
	public void registrarZona(Zona zona) {
		this.zonas.add(zona);
	}
	
	public void registrarEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamientos.add(estacionamiento);
	}
	
	public void registrarCredito() {		
	}
	
	public void registrarInfraccion(Infraccion infraccion) {
		this.infracciones.add(infraccion);
	}
	
	public void registrarApp(AppGobierno app) {
		this.apps.add(app);
	}
}