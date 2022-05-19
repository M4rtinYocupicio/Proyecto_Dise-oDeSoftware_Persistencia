/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entities.Congreso;
import Entities.Profesor;
import Entities.Proyecto;
import Entities.Publicacion;
import Entities.Revista;
import Interfaces.ICongresosDAO;
import Interfaces.IPersistencia;
import Interfaces.IProfesoresDAO;
import Interfaces.IProyectosDAO;
import Interfaces.IPublicacionesDAO;
import Interfaces.IRevistasDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author marti
 */
public class Persistencia implements IPersistencia
{
    private IProyectosDAO proyectosDAO;
    private IProfesoresDAO profesoresDAO;
    private IPublicacionesDAO publicacionesDAO;
    private IRevistasDAO revistasDAO;
    private ICongresosDAO congresosDAO;

    public Persistencia() 
    {
        proyectosDAO=DAOsFactory.crearProyectoDAO();
    }

    @Override
    public boolean agregarProyecto(Proyecto proyecto) 
    {
        return proyectosDAO.agregar(proyecto);
    }

    @Override
    public List<Proyecto> consultarTodosProyectos() 
    {
        return proyectosDAO.consultarTodos();
    }

    @Override
    public Proyecto consultarProyectos(ObjectId idProyecto) 
    {
        return proyectosDAO.consultar(idProyecto);
    }

    @Override
    public boolean agregarProfesores(Profesor profesor) 
    {
        return profesoresDAO.agregar(profesor);
    }

    @Override
    public List<Profesor> consultarTodosProfesores() 
    {
        return profesoresDAO.consultarTodos();
    }

    @Override
    public Profesor consultarProfesores(ObjectId idProfesor) 
    {
        return profesoresDAO.consultar(idProfesor);
    }

    @Override
    public Proyecto editarProyectos(ObjectId idProyecto) 
    {
        return proyectosDAO.editar(idProyecto);
    }

    @Override
    public boolean agregarPublicacion(Publicacion publicacion) 
    {
        return publicacionesDAO.agregar(publicacion);
    }

    @Override
    public boolean agregarRevista(Revista revista) 
    {
        return revistasDAO.agregar(revista);
    }

    @Override
    public boolean agregarCongreso(Congreso congreso) 
    {
        return congresosDAO.agregar(congreso);
    }
    
}