package tpIntegrador.semCompra;

import java.util.ArrayList;

import tpIntegrador.celular.ISEMCelular;

public class SEMCompra implements ISEMCompra{

	private ArrayList<Compra> compras;
	private ISEMCelular semCelular;
	private Integer proxNroControl;
	
	public SEMCompra() {
		this.compras = new ArrayList<Compra>();
		this.proxNroControl = 0; 
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}
	
	public ISEMCelular getSemCelular() {
		return semCelular;
	}

	public Integer getProxNroControl() {
		return proxNroControl;
	}
	
	public void setProxNroControl(Integer nroControl) {
		this.proxNroControl = nroControl;
	}

	public void registrar(Compra compra) {
		this.compras.add(compra);
	}
	
	@Override
	public void generarCompraPuntual(Integer cantDeHoras) {
		CompraPuntual compraPuntual = new CompraPuntual(puntoDeVenta, cantDeHoras);
		compraPuntual.setNroControl(this.proxNroControl);
		this.proxNroControl += 1;
		this.registrar(compraPuntual);
	}

	@Override
	public void comprarCredito(String nroCelular, float monto) {
		CompraDeCredito compra = new CompraDeCredito(puntoDeVenta, monto, nroCelular);
		this.registrar(compra);
		this.semCelular.compra(nroCelular, monto); 
	}
	
}
