package tpIntegrador.semZona;

import java.util.ArrayList;

public class SEMZona {
	private ArrayList<Zona> zonas;
	
	public SEMZona() {
		setZonas(new ArrayList<Zona>());
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(ArrayList<Zona> zonas) {
		this.zonas = zonas;
	}
	
	public boolean perteneceAZona(IPuntoGeografico pg) {
		return this.getZonas().stream().anyMatch(z -> z.contienePuntoGeografico(pg));
	}
	
	public void registrar(Zona z) {
		this.getZonas().add(z);
	}
}
