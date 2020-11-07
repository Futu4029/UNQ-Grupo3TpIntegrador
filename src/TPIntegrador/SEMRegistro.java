package TPIntegrador;

import java.util.ArrayList;

public class SEMRegistro {

	private ArrayList<Zona> zonas;
	private ArrayList<Comprobante> compras;
	private ArrayList<Estacionamiento> estacionamientos;
	private ArrayList<Celular> celulares;
	private ArrayList<Infraccion> infracciones;
	
	public SEMRegistro() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public ArrayList<Comprobante> getCompras() {
		return compras;
	}

	public ArrayList<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}
	
	public ArrayList<Infraccion> getInfracciones() {
		return infracciones;
	}
	
	public void registrarZona(Zona zona) {
		this.zonas.add(zona);
	}
	
    public void registrarCompra(Comprobante comprobante) {
	    this.compras.add(comprobante);	
	}
	
	public void registrarEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamientos.add(estacionamiento);
	}
	
	public void registrarInfraccion(Infraccion infraccion) {
		this.infracciones.add(infraccion);
	}
}
