package tpIntegrador.semCompra;

import java.util.ArrayList;

import tpIntegrador.celular.ISEMCelular;
import tpIntegrador.semZona.PuntoDeVenta;

public class SEMCompra {

	private ArrayList<Compra> compras;
	private ISEMCelular semCelular;
	private Integer nroControl;
	
	public SEMCompra() {
		this.compras = new ArrayList<Compra>();
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
	
	//@Override
	public void generarCompraPuntual(Integer cantDeHoras, PuntoDeVenta puntoDeVenta) {
		CompraPuntual compraPuntual = new CompraPuntual(puntoDeVenta, cantDeHoras, nroControl);
		this.generarProximoNroControl();
		this.registrar(compraPuntual);
	}

	//@Override
	public void comprarCredito(String nroCelular, float monto, PuntoDeVenta puntoDeVenta) {
		CompraVirtual compra = new CompraVirtual(puntoDeVenta, monto, nroCelular, nroControl);
		this.generarProximoNroControl();
		this.registrar(compra);
		this.semCelular.recargar(nroCelular, monto); 
	}
	
	public void generarProximoNroControl() {
		this.setNroControl(nroControl+1);
	}
	
}
