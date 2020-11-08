package tpIntegrador.appEstacionamiento;

public class AlertaActivada implements ModoAlerta {

	public AlertaActivada() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comenzoACaminar() {
		System.out.println("Deberías iniciar estacionamiento");
	}

	@Override
	public void comenzoAManejar() {
		System.out.println("Deberías finalizar estacionamiento");
	}
}
