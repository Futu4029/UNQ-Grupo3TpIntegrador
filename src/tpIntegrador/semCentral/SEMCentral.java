package tpIntegrador.semCentral;

import tpIntegrador.celular.ISEMCelular;
import tpIntegrador.semCompra.ISEMCompra;
import tpIntegrador.semControl.ISEMControl;
import tpIntegrador.semEstacionamiento.ISEMEstacionamiento;
import tpIntegrador.semSistemaDeAsistencia.ISEMSistemaDeAsistencia;
import tpIntegrador.semZona.ISEMZona;

public class SEMCentral {

	private ISEMCelular semCelular;
	private ISEMZona semZona;
	private ISEMSistemaDeAsistencia semSistemaDeAsistencia;
	private ISEMEstacionamiento semEstacionamiento;
	private ISEMCompra semCompra;
	private ISEMControl semControl;
	
	public SEMCentral(ISEMCelular semCelular, ISEMZona semZona, ISEMSistemaDeAsistencia semSistemaDeAsistencia,
			           ISEMEstacionamiento semEstacionamiento, ISEMCompra semCompra, ISEMControl semControl) {
		this.setSemCelular(semCelular);
		this.setSemZona(semZona);
		this.setSemSistemaDeAsistencia(semSistemaDeAsistencia);
		this.setSemEstacionamiento(semEstacionamiento);
		this.setSemCompra(semCompra);
		this.setSemControl(semControl);
	}

	public ISEMCelular getSemCelular() {
		return semCelular;
	}

	public void setSemCelular(ISEMCelular semCelular) {
		this.semCelular = semCelular;
	}

	public ISEMZona getSemZona() {
		return semZona;
	}
	
	public void setSemZona(ISEMZona semZona) {
		this.semZona = semZona;
	}

	public ISEMSistemaDeAsistencia getSemSistemaDeAsistencia() {
		return semSistemaDeAsistencia;
	}
	
	public void setSemSistemaDeAsistencia(ISEMSistemaDeAsistencia semSistemaDeAsistencia) {
		this.semSistemaDeAsistencia = semSistemaDeAsistencia;
	}

	public ISEMEstacionamiento getSemEstacionamiento() {
		return semEstacionamiento;
	}
	
	public void setSemEstacionamiento(ISEMEstacionamiento semEstacionamiento) {
		this.semEstacionamiento = semEstacionamiento;
	}

	public ISEMCompra getSemCompra() {
		return semCompra;
	}

	public void setSemCompra(ISEMCompra semCompra) {
		this.semCompra = semCompra;
	}
	
	public ISEMControl getSemControl() {
		return semControl;
	}
	
	public void setSemControl(ISEMControl semControl) {
		this.semControl = semControl;
	}	
}
