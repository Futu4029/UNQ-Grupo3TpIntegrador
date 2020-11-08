package tpIntegrador.appEstacionamiento;

public class Manejando extends EstadoMovimiento {

	public Manejando(CompraVirtual app) {
		super(app);
	}

	@Override
	public void manejando() {
		// TODO Auto-generated method stub
	}

	@Override
	public void caminando() {
		this.getApp().setEstadoMovimiento(new Caminando(this.getApp()));
		this.getApp().comenzoACaminar();
	}

}
