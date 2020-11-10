package tpIntegrador.semZona;

import tpIntegrador.semCompra.CompraDeCredito;
import tpIntegrador.semCompra.CompraPuntual;
import tpIntegrador.semCompra.ISEMCompra;
import tpIntegrador.semCompra.SEMCompra;

public class PuntoDeVenta implements ISEMCompra{
	
	private SEMCompra semCompra;
	
	public PuntoDeVenta(SEMCompra semCompra) {
		this.semCompra = semCompra;
	}

	@Override
	public void generarCompraPuntual(Integer cantHoras) {
		CompraPuntual compraPuntual = new CompraPuntual(this, cantHoras);
		compraPuntual.setNroControl(semCompra.getProxNroControl());
		semCompra.setProxNroControl() += 1;
		semCompra.registrar(compraPuntual);
	}

	@Override
	public void comprarCredito(String nroCelular, float monto) {
		CompraDeCredito compra = new CompraDeCredito(this, monto, nroCelular);
		semCompra.registrar(compra);
		semCompra.semCelular.compra(nroCelular, monto); 
		
	}
}
