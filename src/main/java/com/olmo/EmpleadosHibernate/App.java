package com.olmo.EmpleadosHibernate;

import com.olmo.EmpleadosHibernate.entity.Departamento;
import com.olmo.EmpleadosHibernate.repository.DepartamentoDAO;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	
    	DepartamentoDAO deptDAO = new DepartamentoDAO();
    	
    	System.out.println(deptDAO.read(2));
    	
    	
    }
}
