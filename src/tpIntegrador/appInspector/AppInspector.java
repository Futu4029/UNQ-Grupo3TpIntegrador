package tpIntegrador.appInspector;

import java.time.LocalDate;
import java.time.LocalTime;

import tpIntegrador.Zona;
import tpIntegrador.estacionamiento.ISEMEstacionamiento;
import tpIntegrador.semControl.ISEMControl;
import tpIntegrador.semControl.Infraccion;

public class AppInspector {
	
	private String inspector;
	private ISEMControl control;
	private ISEMEstacionamiento estacionamiento;

	public AppInspector(String inspector, ISEMControl control, ISEMEstacionamiento estacionamiento) {
		this.inspector = inspector;
		this.control = control;
		this.estacionamiento = estacionamiento;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public ISEMControl getControl() {
		return control;
	}

	public void setControl(ISEMControl control) {
		this.control = control;
	}

	public ISEMEstacionamiento getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(ISEMEstacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
	
	public Boolean estaVigentePatente(String patente) {
		return estacionamiento.estaVigentePatente(patente);
	}
	
	public void registrarInfraccion(String patente, Zona zona) {
		Infraccion infraccion = new Infraccion(patente, LocalDate.now(), LocalTime.now(), inspector, zona);
		control.registrarInfraccion(infraccion);
	}

}
