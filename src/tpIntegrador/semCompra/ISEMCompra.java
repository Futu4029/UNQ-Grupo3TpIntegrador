package tpIntegrador.semCompra;

import tpIntegrador.semZona.PuntoDeVenta;

public interface ISEMCompra {

	public void generarCompraPuntual(Integer cantDeHoras, PuntoDeVenta puntoDeVenta);
	public void comprarCredito(String nroCelular, float monto, PuntoDeVenta puntoDeVenta);
	
}
