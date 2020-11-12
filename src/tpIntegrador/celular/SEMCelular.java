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
    
    public float consultarCredito(String nroCelular) {
		float credito = 
				this.getCelulares().containsKey(nroCelular)
					? this.getCelulares().get(nroCelular)
					: 0;
				return credito;
    }
    
    public void recargar(String nroCelular, float montoARecargar) {
    	float valor = (this.getCelulares().get(nroCelular));
    	float montoCambiado = valor + montoARecargar;
    	this.getCelulares().remove(nroCelular);
		this.agregar(nroCelular, montoCambiado);
    }
    
    public void descontarCredito(String nroCelular, float montoADescontar) {
    	float valor = (this.getCelulares().get(nroCelular));
    	float montoCambiado = valor - montoADescontar;
    	this.getCelulares().remove(nroCelular);
    	this.agregar(nroCelular, montoCambiado);
	}

	public void agregar(String nroCelular, float credito) {
		this.celulares.put(nroCelular, credito);
	}

	public Boolean tieneCreditoSuficiente(String nroCelular, float creditoNecesitado) {
		float valor = this.getCelulares().get(nroCelular);
		return creditoNecesitado >= valor;
	}	
	
	public Boolean contieneRecargaRealizadaDe(String nroCelular) {
		return this.getCelulares().containsKey(nroCelular);
		
	}
}