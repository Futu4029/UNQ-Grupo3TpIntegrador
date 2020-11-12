package tpIntegrador.semCompra;

import java.util.ArrayList;

import tpIntegrador.celular.SEMCelular;
import tpIntegrador.semZona.PuntoDeVenta;

public class SEMCompra implements ISEMCompra{

	private ArrayList<Compra> compras;
	private SEMCelular semCelular;
	private Integer nroControl;
	
	public SEMCompra(SEMCelular semCelular) {
		this.compras = new ArrayList<Compra>();
		this.semCelular =  semCelular;
		this.nroControl = 0; 
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}
	
	public SEMCelular getSemCelular() {
		return semCelular;
	}

	public Integer getNroControl() {
		return nroControl;
	}
	
	public void setNroControl(Integer nroControl) {
		this.nroControl = nroControl;
	}

	public void registrar(Compra compra) {
		this.compras.add(compra);
	}
	
	public void generarProximoNroControl() {
		this.setNroControl(nroControl+1);
	}
	
	public Boolean contieneCompra(Compra compra) {
		return this.getCompras().contains(compra);
	}
	
	//@Override
	public void generarCompraPuntual(Integer cantDeHoras, PuntoDeVenta puntoDeVenta) {
		CompraPuntual compraPuntual = new CompraPuntual(nroControl, puntoDeVenta, cantDeHoras);
		this.generarProximoNroControl();
		this.registrar(compraPuntual);
	}

	//@Override
	public void comprarCredito(String nroCelular, float monto, PuntoDeVenta puntoDeVenta) {
		CompraVirtual compraVirtual = new CompraVirtual(nroControl, puntoDeVenta, monto, nroCelular);
		this.generarProximoNroControl();
		this.registrar(compraVirtual);
		this.semCelular.recargar(nroCelular, monto); 
	}

}
