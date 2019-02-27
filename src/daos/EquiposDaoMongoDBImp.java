package daos;


import java.util.List;
import driverMongoDB.MongoDBConnection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;  
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;

import idaos.EquiposDao;
import idaos.JugadorDao;
import modelos.Equipos;
import modelos.Jugador;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class EquiposDaoMongoDBImp implements EquiposDao {

	@Override
	public boolean create(Equipos equipo) {
		
		boolean created = false;
		
		try {			
			
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("equipos");
			
			Document doc = new Document();
			
			doc.append("Nombre", equipo.getNombre());
			doc.append("Ciudad",equipo.getCiudad());
			doc.append("Conferencia",equipo.getConferencia());
			doc.append("Division", equipo.getDivision());
	
			coleccion.insertOne(doc);
			created = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Equipos> read() {
		
		MongoDBConnection mdbc = new MongoDBConnection();
		MongoCollection coleccion= mdbc.getCollection("equipos");
		MongoCursor<Document> cursor = coleccion.find().iterator();
		
		List<Equipos> listaEquipos= new ArrayList<Equipos>();
		
		try {
		    while (cursor.hasNext()) {   
		    	
		        Document dbObj = cursor.next();
		        
		        String nombre = dbObj.getString("Nombre");
		        String ciudad = dbObj.getString("Ciudad");
		        String conferencia = dbObj.getString("Conferencia");
		        String division = dbObj.getString("Division");

		        Equipos e = new Equipos(nombre, ciudad, conferencia, division);
		        
		        listaEquipos.add(e);
		    }
		} finally {
		    cursor.close();
		}
		
		return listaEquipos;
	}

	@Override
	public boolean update(Equipos equipo) {
		
		boolean updated = false;
		
		try {
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("equipos");
			
			coleccion.updateOne(eq("Nombre", equipo.getNombre()), 
					combine(set("Ciudad", equipo.getCiudad()), 
							set("Conferencia", equipo.getConferencia()), 
							set("Division", equipo.getDivision())));
			updated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean delete(Equipos equipo) {
		
		boolean deleted = false;
		
		try {
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("equipos");
			coleccion.deleteMany(eq("Nombre", equipo.getNombre()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
	
}
