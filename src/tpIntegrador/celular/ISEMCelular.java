package tpIntegrador.celular;

public interface ISEMCelular {

	public float consultarCredito(String nroCelular);
	
	public void recargar(String nroCelular, float monto);
	
	public void agregar(String nroCelular, float credito);
	
	public Boolean tieneCreditoSuficiente(String nroCelular, float credito);
}

