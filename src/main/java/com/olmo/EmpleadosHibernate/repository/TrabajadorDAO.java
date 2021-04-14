package com.olmo.EmpleadosHibernate.repository;

import java.sql.Date;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.olmo.EmpleadosHibernate.entity.Departamento;
import com.olmo.EmpleadosHibernate.entity.Direccion;
import com.olmo.EmpleadosHibernate.entity.Trabajador;
import com.olmo.EmpleadosHibernate.entity.Trabajo;
import com.olmo.EmpleadosHibernate.service.HibernateUtil;


public class TrabajadorDAO {

	// Obtenemos el SessionFactory

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void create(Integer id, String nombre, String apellidos, String email, String tlf, Date fecha_alta,
			Trabajo trabajo, Departamento dept) {

		// Abrimos la sesi�n mediante el SessionFactory
		Session session = sessionFactory.openSession();

		// Creamos el objeto
		Trabajador trabajador = new Trabajador(id,nombre,apellidos,email,tlf,fecha_alta,trabajo,dept);
		
		
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

	public Trabajador read(Integer id) {

		// Abrimos la sesi�n mediante el SessionFactory
		Session session = sessionFactory.openSession();
		Trabajador trabajador = (Trabajador) session.get(Trabajador.class, id);
		session.close();
		sessionFactory.close();
		return trabajador;
	}
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
		Trabajador trabajador = (Trabajador) session.get(Trabajador.class, id);
		session.delete(trabajador);
		session.close();
		sessionFactory.close();
		
	}

}
