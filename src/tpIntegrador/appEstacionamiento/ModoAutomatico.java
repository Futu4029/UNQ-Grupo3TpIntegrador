package tpIntegrador.appEstacionamiento;

public class ModoAutomatico implements ModoApp {

	public ModoAutomatico() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void comenzoACaminar(EstacionamientoApp app, String patente, String celular) {
		app.inicioEstacionamiento(patente, celular);
		
	}

	@Override
	public void comenzoAManejar(EstacionamientoApp app, String celular) {
		app.finEstacionamiento(celular);
	}

}
