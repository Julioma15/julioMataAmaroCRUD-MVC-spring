package com.anahuac.desarrollo.persistance;

import java.util.List;

import com.anahuac.desarrollo.entities.Libro;

public interface IDAOLibro {
	public List<Libro> findAll();
    public int createLibro(Libro libro);
    public Libro findById(int id);
    public boolean deleteLibro(int id);
    public Libro findByNombre(String nombre);
    public Libro updateLibro(Libro libro);
    public Libro findByIsbn(String isbn);

}
