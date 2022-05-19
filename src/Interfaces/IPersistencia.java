/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Profesor;
import Entities.Proyecto;
import Entities.Publicacion;
import Entities.Revista;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author marti
 */
public interface IPersistencia 
{
    boolean agregarProyecto(Proyecto proyecto);
    List<Proyecto> consultarTodosProyectos();
    Proyecto consultarProyectos(ObjectId idProyecto);
    Proyecto editarProyectos(ObjectId idProyecto);
    
    boolean agregarProfesores(Profesor profesor);
    List<Profesor> consultarTodosProfesores();
    Profesor consultarProfesores(ObjectId idProfesor);
    
    boolean agregar(Publicacion publicacion);
    
    boolean agregar(Revista revista);
}
