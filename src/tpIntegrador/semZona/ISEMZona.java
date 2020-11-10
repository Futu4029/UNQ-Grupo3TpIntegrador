package tpIntegrador.semZona;

import java.util.ArrayList;

public interface ISEMZona {
	public ArrayList <Zona> getZonas(); 
	public boolean perteneceAZona(IPuntoGeografico puntoGeografico);
	public void agregarZona(Zona zona);
}
