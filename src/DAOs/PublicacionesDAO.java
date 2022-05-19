/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entities.Publicacion;
import Interfaces.IConexionBD;
import Interfaces.IPublicacionesDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author marti
 */
public class PublicacionesDAO implements IPublicacionesDAO
{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public PublicacionesDAO(IConexionBD conexion) 
    {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Publicacion> getColeccion()
    {
        return this.baseDatos.getCollection("publicacion", Publicacion.class);
    }
    
    @Override
    public boolean agregar(Publicacion publicacion) 
    {
        MongoCollection<Publicacion> coleccion = this.getColeccion();
        coleccion.insertOne(publicacion);
        return true;
    }
    
}
