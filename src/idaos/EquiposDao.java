package idaos;

import java.util.List;

import modelos.Equipos;
import modelos.Jugador;

public interface EquiposDao {
	
	public boolean create(Equipos equipo);
	public List<Equipos>read();
	public boolean update(Equipos equipo);
	public boolean delete(Equipos equipo);
	
}
