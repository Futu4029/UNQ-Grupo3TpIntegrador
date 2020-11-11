package tpIntegrador.semEstacionamiento;

import java.time.LocalTime;
import java.util.ArrayList;

import tpIntegrador.estacionamiento.Estacionamiento;
import tpIntegrador.semSistemaDeAsistencia.notificacion.Notificacion;

public interface ISEMEstacionamiento {
	public ArrayList<Estacionamiento> getEstacionamientos(); 
	public boolean estaVigentePatente(String patente);
	public boolean estaVigenteCelular(String nroCelular);
	public Estacionamiento buscarEstacionamientoVigente(String nroCelular);
	public void registrar(Estacionamiento estacionamiento);
	public void finalizarTodosEstacionamientos();
	public boolean estaEnFranjaHoraria();
	public Notificacion inicioEstacionamiento(String patente, LocalTime horaFin);
	public Notificacion finEstacionamiento(String patente, LocalTime horaFin);
	public Boolean estaEnZonaDeEstacionamiento(String patente);
}
