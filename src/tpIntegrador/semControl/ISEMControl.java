package tpIntegrador.semControl;

import java.util.ArrayList;

public interface ISEMControl {
	
	public ArrayList<Infraccion> getInfracciones();
	
	public void registrarInfraccion(Infraccion infraccion);
	
	
}
