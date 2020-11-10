package tpIntegrador.semControl;

import java.util.ArrayList;

public class SEMControl implements ISEMControl {
	
	private ArrayList<Infraccion> infracciones;
	
	public SEMControl() {
		super();
		this.infracciones = new ArrayList<Infraccion>();
	}


	@Override
	public ArrayList<Infraccion> getInfracciones() {
		return infracciones;
	}
	
	@Override
	public void registrarInfraccion(Infraccion infraccion) {
		this.infracciones.add(infraccion);
	}

}
