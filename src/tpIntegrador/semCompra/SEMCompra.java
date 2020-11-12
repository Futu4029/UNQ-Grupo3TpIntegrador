package tpIntegrador.semCompra;

import java.util.ArrayList;

import tpIntegrador.celular.ISEMCelular;
import tpIntegrador.semZona.PuntoDeVenta;

public class SEMCompra implements ISEMCompra{

	private ArrayList<Compra> compras;
	private ISEMCelular semCelular;
	private Integer nroControl;
	
	public SEMCompra(ISEMCelular semCelular) {
		this.compras = new ArrayList<Compra>();
		this.semCelular =  semCelular;
		this.nroControl = 0; 
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}
	
	public ISEMCelular getSemCelular() {
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
