package tpIntegrador.appEstacionamiento;

public class ModoAutomatico implements ModoApp {

	public ModoAutomatico() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void comenzoACaminar(CompraVirtual app, String patente, Integer celular) {
		app.inicioEstacionamiento(patente, celular);
		System.out.println("Se ha iniciado un estacionamiento");
		
	}

	@Override
	public void comenzoAManejar(CompraVirtual app, String patente, Integer celular) {
		app.finEstacionamiento(celular);
		System.out.println("Se ha finalizado un estacionamiento");
	}

}
