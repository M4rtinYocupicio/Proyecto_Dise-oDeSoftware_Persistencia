/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entities.Profesor;
import Interfaces.IConexionBD;
import Interfaces.IProfesoresDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author marti
 */
public class ProfesoresDAO implements IProfesoresDAO
{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public ProfesoresDAO(IConexionBD conexion) 
    {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Profesor> getColeccion()
    {
        return this.baseDatos.getCollection("profesores", Profesor.class);
    }
    
    @Override
    public boolean agregar(Profesor profesor) 
    {
        MongoCollection<Profesor> coleccion = this.getColeccion();
        try
        {   
            System.out.println("Error" +profesor.toString());
            coleccion.insertOne(profesor);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }

    @Override
    public List<Profesor> consultarTodos() {
        MongoCollection<Profesor> coleccion = this.getColeccion();
        List<Profesor> listaProfesores = new LinkedList<>();
        coleccion.find().into(listaProfesores);
        return listaProfesores;
    }

    @Override
    public Profesor consultar(ObjectId idProyecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
