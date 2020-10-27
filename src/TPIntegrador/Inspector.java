package TPIntegrador;

public class Inspector {

	private Zona zona;
	private Celular celular;
	
	public Inspector(Zona zona, Celular celular) {
		this.zona = zona;
		this.celular = celular;
	}

	public Zona getZona() {
		return zona;
	}

	public Celular getCelular() {
		return celular;
	}
}
