package tpIntegrador.appEstacionamiento;

public class AlertaActivada implements ModoAlerta {

	public AlertaActivada() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comenzoACaminar() {
		System.out.println("Deber�as iniciar estacionamiento");
	}

	@Override
	public void comenzoAManejar() {
		System.out.println("Deber�as finalizar estacionamiento");
	}
}
