package TPIntegrador;

public class Zona {

    private ArrayList<PuntoDeVenta> puntosDeVentas;
    private Inspector inspector;
    
	public Zona(Inspector inspector) {
		this.inspector = inspector;
	}

	public ArrayList<PuntoDeVenta> getPuntosDeVentas() {
		return puntosDeVentas;
	}

	public Inspector getInspector() {
		return inspector;
	}
}
