package tpIntegrador.semZona;

import java.util.ArrayList;

public class Zona {
	public ArrayList<PuntoDeVenta> puntosDeVenta;
	public String inspector;
	public ArrayList<IPuntoGeografico> puntosGeograficos;
	
	public Zona(String inspector) {
		this.inspector = inspector;
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
		this.puntosGeograficos = new ArrayList<IPuntoGeografico>();
	}
	//Setters y Getters

	public ArrayList<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}

	public String getInspector() {
		return inspector;
	}

	public ArrayList<IPuntoGeografico> getPuntosGeograficos() {
		return puntosGeograficos;
	}

	public void setPuntosDeVenta(ArrayList<PuntoDeVenta> puntosDeVenta) {
		this.puntosDeVenta = puntosDeVenta;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public void setPuntosGeograficos(ArrayList<IPuntoGeografico> puntosGeograficos) {
		this.puntosGeograficos = puntosGeograficos;
	}
	
	public void registrarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.getPuntosDeVenta().add(puntoDeVenta);
	}
	
	public void registrarPuntoGeografico(IPuntoGeografico puntoGeografico) {
		this.getPuntosGeograficos().add(puntoGeografico);
	}
	// se le pregunta a su colecci�n si contiene un punto de venta
  
	public boolean contienePuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		return this.getPuntosDeVenta().contains(puntoDeVenta);
	}
	// se le pregunta a su colecci�n si contiene un punto geografico
	public boolean contienePuntoGeografico(IPuntoGeografico puntoGeografico) {
		return this.getPuntosGeograficos().contains(puntoGeografico);
	}
}
