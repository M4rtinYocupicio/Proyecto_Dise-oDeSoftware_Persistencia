/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entities.Revista;
import Interfaces.IConexionBD;
import Interfaces.IRevistasDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author marti
 */
public class RevistasDAO implements IRevistasDAO 
{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public RevistasDAO(IConexionBD conexion) 
    {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Revista> getColeccion()
    {
        return this.baseDatos.getCollection("publicacion", Revista.class);
    }
    
    @Override
    public boolean agregar(Revista revista) 
    {
        MongoCollection<Revista> coleccion = this.getColeccion();
        coleccion.insertOne(revista);
        return true;
    }
    
}
