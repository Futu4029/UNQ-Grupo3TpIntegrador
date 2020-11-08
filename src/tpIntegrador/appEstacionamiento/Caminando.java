package tpIntegrador.appEstacionamiento;

public class Caminando extends EstadoMovimiento {

	public Caminando(CompraVirtual app) {
		super(app);
	}

	@Override
	public void manejando() {
		this.getApp().setEstadoMovimiento(new Manejando(this.getApp()));
		this.getApp().comenzoAManejar();
	}

	@Override
	public void caminando() {
		// TODO Auto-generated method stub

	}

}
