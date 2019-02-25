package vistas;

import java.util.List;

import modelos.Equipos;
import modelos.Jugador;

public class ViewEquipos {
	
	public void viewEquipo(Equipos equipo) {
		System.out.println("Datos del equipo: " +equipo);
	}
	
	public void viewTodosEquipos(List<Equipos> equipos) {
		for (Equipos equipo: equipos) {
			System.out.println("Datos del equipo: "+ equipo);
		}
	}
}
