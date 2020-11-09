package tpIntegrador.appEstacionamiento;

public class EstadoCaminando extends EstadoMovimiento {

	public EstadoCaminando(EstacionamientoApp app) {
		super(app);
	}

	@Override
	public void manejando() {
		this.getApp().setEstadoMovimiento(new EstadoManejado(this.getApp()));
		this.getApp().comenzoAManejar();
	}

	@Override
	public void caminando() {
		// TODO Auto-generated method stub

	}

}
