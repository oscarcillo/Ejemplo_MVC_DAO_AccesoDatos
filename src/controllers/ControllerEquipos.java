package controllers;


import java.util.ArrayList;
import java.util.List;

import daos.JugadorDaoMySQLImp;
import daos.EquiposDaoMongoDBImp;
import daos.JugadorDaoMongoDBImp;
import idaos.EquiposDao;
import idaos.JugadorDao;
import modelos.Equipos;
import modelos.Jugador;
import vistas.ViewEquipos;
import vistas.ViewJugador;

public class ControllerEquipos {
	
	private ViewEquipos vista = new ViewEquipos();
	
	
	public ControllerEquipos() {
	}
	
	public void create(Equipos equipo) {
		//EquiposDao dao = new EquiposDaoMySQLImp();
		EquiposDao daoMongo = new EquiposDaoMongoDBImp();
	//	dao.create(jugador);
		daoMongo.create(equipo);
	}
	
	public void update(Equipos equipo) {
		//JugadorDao dao = new JugadorDaoMySQLImp();
		//dao.update(equipo);
	}
	
	public void remove(Equipos equipo) {
		//JugadorDao dao = new JugadorDaoMySQLImp();
		//dao.delete(jugador);
	}
	
	public void viewEquipos() {
		
		/*List<Equipos> equipos = new ArrayList<Equipos>();
		JugadorDao dao = new JugadorDaoMySQLImp();
		
		
		 equipos = dao.read();
		 vista.viewTodosJugadores(equipos);*/
		
		
		
		EquiposDao daoMongo = new EquiposDaoMongoDBImp();
		List<Equipos> equiposMongo = new ArrayList<Equipos>();
		equiposMongo = daoMongo.read();
		vista.viewTodosEquipos((equiposMongo));
		
		
	}
	
	public void viewEquipos(Equipos equipo) {
		vista.viewEquipo(equipo);
	}
}
