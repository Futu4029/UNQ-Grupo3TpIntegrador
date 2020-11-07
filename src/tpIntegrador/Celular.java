package tpIntegrador;

public class Celular {

	private String numero;
	private float credito;
	
	public Celular(String numero) {
		this.numero = numero;
		this.credito = 0;
	}

	public String getNumero() {
		return numero;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}
	
}
