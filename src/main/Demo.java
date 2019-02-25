package main;

import controllers.ControllerEquipos;
import controllers.ControllerJugador;
import modelos.Jugador;

public class Demo {

	public static void main(String[] args) {
		
		ControllerJugador controller = new ControllerJugador();
		ControllerEquipos controllerEquipos = new ControllerEquipos();
		/*
		Jugador j = new Jugador(0, "fulanito", "Raptors", "Tarazona", "6-2", "C", 195);
	
		
		
		
		controller.create(j);
		
		controller.viewJugadores();

		
		j.setAltura("7-2");
		j.setNombre_equipo("Lakers");
		controller.update(j);
		
		controller.viewJugador(j);
		
		controller.remove(j);
		*/
		controller.viewJugadores();
		controllerEquipos.viewEquipos();

	}

}
