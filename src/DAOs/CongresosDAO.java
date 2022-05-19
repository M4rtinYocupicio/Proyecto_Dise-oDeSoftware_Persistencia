/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entities.Congreso;
import Interfaces.IConexionBD;
import Interfaces.ICongresosDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author marti
 */
public class CongresosDAO implements ICongresosDAO
{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public CongresosDAO(IConexionBD conexion) 
    {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Congreso> getColeccion()
    {
        return this.baseDatos.getCollection("publicacion", Congreso.class);
    }
    @Override
    public boolean agregar(Congreso congreso) 
    {
        MongoCollection<Congreso> coleccion = this.getColeccion();
        coleccion.insertOne(congreso);
        return true;
    }
    
}
