package tpIntegrador;

public class CompraVirtual extends Estacionamiento implements MovementSensor{

	private Celular celular;
	private ModoApp modo;
	private // (? puntoGeografico;
	
	public CompraVirtual(String patente, Celular celular) {
		super(patente);
		this.celular =  celular;
		this.modo = new Automatico();
		////
	}
	
	public Celular getCelular() {
		return celular;
	}
	
	public void inicioEstacionamiento(String patente) { 
	}
	
	public void finEstacionamiento() {
		
	}
	
	public double consultarCredito() {  /// float (?
		
	}
	
	public void generarComprobante() {
		
	}
	
	public void alternarModo() {
		
	}
	
	public void driving() {
		
	}
	
	public void walking() {
		
	}
}
