package tpIntegrador.appEstacionamiento;

public abstract class EstadoMovimiento {
	private EstacionamientoApp app;

	public EstadoMovimiento(EstacionamientoApp app) {
		super();
		this.app = app;
	}
	
	
	public EstacionamientoApp getApp() {
		return app;
	}



	public void setApp(EstacionamientoApp app) {
		this.app = app;
	}


	public abstract void manejando();
	
	public abstract void caminando();
	
}
