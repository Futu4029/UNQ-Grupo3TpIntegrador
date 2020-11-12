package tpIntegrador.appEstacionamiento;

public class EstadoManejando extends EstadoMovimiento {

	public EstadoManejando(EstacionamientoApp app) {
		super(app);
	}

	@Override
	public void manejando() {
		// TODO Auto-generated method stub
	}

	@Override
	public void caminando() {
		this.getApp().setEstadoMovimiento(new EstadoCaminando(this.getApp()));
		this.getApp().comenzoACaminar();
	}

}
