package tpIntegrador.appEstacionamiento;

public abstract class EstadoMovimiento {
	private CompraVirtual app;

	public EstadoMovimiento(CompraVirtual app) {
		super();
		this.app = app;
	}
	
	
	public CompraVirtual getApp() {
		return app;
	}



	public void setApp(CompraVirtual app) {
		this.app = app;
	}


	public abstract void manejando();
	
	public abstract void caminando();
	
}
