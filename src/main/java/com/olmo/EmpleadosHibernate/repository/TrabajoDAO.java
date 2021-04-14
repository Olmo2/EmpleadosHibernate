package com.olmo.EmpleadosHibernate.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.olmo.EmpleadosHibernate.entity.Departamento;
import com.olmo.EmpleadosHibernate.entity.Trabajador;
import com.olmo.EmpleadosHibernate.entity.Trabajo;
import com.olmo.EmpleadosHibernate.service.HibernateUtil;


public class TrabajoDAO {

	// Obtenemos el SessionFactory

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void create(Integer id, String nombre, float salario_min, float salario_max, List<Trabajador> trabajadores) {

		// Abrimos la sesión mediante el SessionFactory
		Session session = sessionFactory.openSession();

		// Creamos el objeto
		Trabajo trabajador = new Trabajo(id,nombre,salario_min,salario_max, trabajadores);
		
		
		Transaction tx = (Transaction) session.beginTransaction();

		session.save(trabajador);// <|--- Aqui guardamos el objeto en la base de datos.

		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		session.close();
		sessionFactory.close();

	}

	public Trabajo read(Integer id) {

		// Abrimos la sesión mediante el SessionFactory
		Session session = sessionFactory.openSession();
		Trabajo trabajo = (Trabajo) session.get(Trabajo.class, id);
		session.close();
		sessionFactory.close();
		return trabajo;
	}
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
		Trabajo trabajo = (Trabajo) session.get(Trabajo.class, id);
		session.delete(trabajo);
		session.close();
		sessionFactory.close();
		
	}
}
