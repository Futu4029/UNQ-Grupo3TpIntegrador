package tpIntegrador.semZona;

import java.util.ArrayList;

public class Zona {
	public ArrayList<String> puntosDeVenta;
	public String inspector;
	public ArrayList<IPuntoGeografico> puntosGeograficos;
	
	public Zona(String inspector) {
		this.inspector = inspector;
		this.puntosDeVenta = new ArrayList<String>();
		this.puntosGeograficos = new ArrayList<IPuntoGeografico>();
	}

	public ArrayList<String> getPuntosDeVenta() {
		return puntosDeVenta;
	}

	public String getInspector() {
		return inspector;
	}

	public ArrayList<IPuntoGeografico> getPuntosGeograficos() {
		return puntosGeograficos;
	}

	public void setPuntosDeVenta(ArrayList<String> puntosDeVenta) {
		this.puntosDeVenta = puntosDeVenta;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public void setPoligono(ArrayList<IPuntoGeografico> puntosGeograficos) {
		this.puntosGeograficos = puntosGeograficos;
	}
	
	public void registrarPuntoDeVenta(String puntoDeVenta) {
		this.getPuntosDeVenta().add(puntoDeVenta);
	}
	
	public void registrarPuntoGeografico(IPuntoGeografico puntoGeografico) {
		this.getPuntosGeograficos().add(puntoGeografico);
	}
	
	public boolean contienePuntoDeVenta(String puntoDeVenta) {
		return this.getPuntosDeVenta().contains(puntoDeVenta);
	}
	
	public boolean contienePuntoGeografico(IPuntoGeografico puntoGeografico) {
		return this.getPuntosGeograficos().contains(puntoGeografico);
	}
}
