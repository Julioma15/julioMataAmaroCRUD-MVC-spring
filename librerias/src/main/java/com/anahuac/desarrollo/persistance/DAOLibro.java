package com.anahuac.desarrollo.persistance;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

import com.anahuac.desarrollo.entities.Libro;
import com.anahuac.desarrollo.main.HibernateUtil;


public class DAOLibro implements IDAOLibro{
	
	@Override
	public int createLibro(Libro libro) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    int id = (int) session.save(libro);
	    tx.commit();
	    session.close();

	    return id;
	}

    @Override
    public List<Libro> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Libro");
        List<Libro> lista = query.getResultList();
        session.close();
        return lista;
    }

    @Override
    public Libro findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Libro libro = session.get(Libro.class, id);
        session.close();
        return libro;
    }

    @Override
    public boolean deleteLibro(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Libro libro = session.get(Libro.class, id);
        session.delete(libro);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Libro findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Libro WHERE nombre = :nombre");
        query.setParameter("nombre", nombre);
        Libro libro = (Libro) query.uniqueResult();
        session.close();
        return libro;
    }

    @Override
    public Libro updateLibro(Libro libro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(libro);
        session.getTransaction().commit();
        session.close();
        return libro;
    }

    @Override
    public Libro findByIsbn(String isbn) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Libro WHERE isbn = :isbn");
        query.setParameter("isbn", isbn);

        Libro libro = (Libro) query.uniqueResult();

        return libro;
    }

}

