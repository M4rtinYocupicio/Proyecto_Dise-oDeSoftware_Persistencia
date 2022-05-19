/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IConexionBD;
import Interfaces.ICongresosDAO;
import Interfaces.IProfesoresDAO;
import Interfaces.IProyectosDAO;
import Interfaces.IPublicacionesDAO;
import Interfaces.IRevistasDAO;

/**
 *
 * @author marti
 */
public class DAOsFactory 
{
    private static final IConexionBD conexionBD= new ConexionBD();
    
    public static IProyectosDAO crearProyectoDAO()
    {
        return new ProyectosDAO(conexionBD);
    }
    
    public static IProfesoresDAO crearProfesoresDAO()
    {
        return new ProfesoresDAO(conexionBD);
    }
    
    public static IPublicacionesDAO crearPublicacionesDAO()
    {
        return new PublicacionesDAO(conexionBD);
    }
    
    public static IRevistasDAO crearRevistasDAO()
    {
        return new RevistasDAO(conexionBD);
    }
    
    public static ICongresosDAO crearCongresosDAO()
    {
        return new CongresosDAO(conexionBD);
    }
}
