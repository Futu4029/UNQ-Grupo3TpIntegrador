package tpIntegrador.celular;

import java.util.HashMap;

public class SEMCelular implements ISEMCelular {

    private HashMap<String,Float> celulares;
    
    public SEMCelular() {	
    	this.celulares = new HashMap<String,Float>();
    }

	public HashMap<String,Float> getCelulares() {
		return celulares;
	}
    
	@Override
    public float consultarCredito(String nroCelular) {
		float credito = 
				this.getCelulares().containsKey(nroCelular)
					? this.getCelulares().get(nroCelular)
					: 0;
				return credito;
    }
    
    public void recargar(String nroCelular, float monto) {
    	float recarga = (this.getCelulares().get(nroCelular));
    	this.getCelulares().remove(nroCelular);
    	
		this.getCelulares().put(nroCelular, recarga + monto);
    }

	@Override
	public void agregar(String nroCelular, float credito) {
		this.celulares.put(nroCelular, credito);
	}

	@Override
	public Boolean tieneCreditoSuficiente(String nroCelular, float creditoNecesitado) {
		float valor = this.getCelulares().get(nroCelular);
		return creditoNecesitado >= valor;
	}	
}