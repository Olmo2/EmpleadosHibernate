package com.olmo.EmpleadosHibernate;

import com.olmo.EmpleadosHibernate.entity.Departamento;
import com.olmo.EmpleadosHibernate.entity.Direccion;
import com.olmo.EmpleadosHibernate.repository.DepartamentoDAO;
import com.olmo.EmpleadosHibernate.repository.DireccionDAO;
import com.olmo.EmpleadosHibernate.repository.PaisDAO;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	
    	DepartamentoDAO deptDAO = new DepartamentoDAO();
    	DireccionDAO dirDAO = new DireccionDAO();
    	PaisDAO paisDAO = new PaisDAO();
    	
    	System.out.println(deptDAO.read(2));
    	System.out.println(dirDAO.read(1400));
    	System.out.println(paisDAO.read("US"));
    
    	
    	
    }
}
