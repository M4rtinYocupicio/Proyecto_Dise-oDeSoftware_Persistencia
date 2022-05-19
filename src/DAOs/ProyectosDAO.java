/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entities.Proyecto;
import Interfaces.IConexionBD;
import Interfaces.IProyectosDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author marti
 */
public class ProyectosDAO implements IProyectosDAO
{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public ProyectosDAO(IConexionBD conexion) 
    {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    private MongoCollection<Proyecto> getColeccion()
    {
        return this.baseDatos.getCollection("proyectos", Proyecto.class);
    }
    
    @Override
    public boolean agregar(Proyecto proyecto) 
    {
        //TODO: MANEJAS POSIBLES EXCEPCIONES...
        MongoCollection<Proyecto> coleccion = this.getColeccion();
        coleccion.insertOne(proyecto);
        return true;
    }

    @Override
    public List<Proyecto> consultarTodos() 
    {
        MongoCollection<Proyecto> coleccion = this.getColeccion();
        List<Proyecto> listaProyectos = new LinkedList<>();
        coleccion.find().into(listaProyectos);
        return listaProyectos;
    }

    @Override
    public Proyecto consultar(ObjectId idProyecto) 
    {
        MongoCollection<Proyecto> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("_id", idProyecto)));
        
        List<Proyecto> proyectos = new LinkedList<>();
        coleccion.aggregate(etapas).into(proyectos);
        return proyectos.get(0);
    }

    @Override
    public Proyecto editar(ObjectId idProyecto) 
    {

        return null;

    }
    
}