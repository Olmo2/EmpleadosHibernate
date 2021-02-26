package com.olmo.EmpleadosHibernate.repository;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.olmo.EmpleadosHibernate.entity.Departamento;
import com.olmo.EmpleadosHibernate.entity.Direccion;
import com.olmo.EmpleadosHibernate.entity.Pais;
import com.olmo.EmpleadosHibernate.entity.Trabajador;
import com.olmo.EmpleadosHibernate.service.HibernateUtil;


public class PaisDAO {

	// Obtenemos el SessionFactory

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void create(String nombre, List<Direccion> direcciones) {

		// Abrimos la sesión mediante el SessionFactory
		Session session = sessionFactory.openSession();

		// Creamos el objeto
		Pais pais = new Pais();
		pais.setNombre(nombre);
		pais.setDirecciones(direcciones);
		
		Transaction tx = (Transaction) session.beginTransaction();

		session.save(pais);// <|--- Aqui guardamos el objeto en la base de datos.

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

	public Pais read(String id) {

		// Abrimos la sesión mediante el SessionFactory
		Session session = sessionFactory.openSession();
		Pais pais = (Pais) session.get(Pais.class, id);
		session.close();
//		sessionFactory.close();
		return pais;
	}

}
