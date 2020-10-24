package TPIntegrador;

public class Usuario {

	private float saldo;
	private Celular celular;
	
	public Usuario(float saldo, Celular celular) {
		this.saldo = saldo;
		this.celular = celular;
	}

	public float getSaldo() {
		return saldo;
	}

	public Celular getCelular() {
		return celular;
	}

}
