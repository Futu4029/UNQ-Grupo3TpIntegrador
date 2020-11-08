package tpIntegrador.appEstacionamiento;

public class ModoAutomatico implements ModoApp {

	public ModoAutomatico() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void comenzoACaminar(CompraVirtual app, String patente, Integer celular) {
		app.inicioEstacionamiento(patente, celular);
		
	}

	@Override
	public void comenzoAManejar(CompraVirtual app, Integer celular) {
		app.finEstacionamiento(celular);
	}

}
