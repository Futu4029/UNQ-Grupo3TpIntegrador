package tpIntegrador.semCompra;

public class CompraPuntual extends Compra {

	private int cantidadDeHoras;
	
	public CompraPuntual(String puntoDeVenta, int horas) {
		super(puntoDeVenta);
		this.cantidadDeHoras = horas;
	}

	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}
	
}