package com.anahuac.desarrollo.service;

import java.util.List;
import com.anahuac.desarrollo.entities.Libro;
import com.anahuac.desarrollo.persistance.IDAOLibro;


public class LibroService {
	
	private IDAOLibro daoLibro;

    public LibroService(IDAOLibro libroDao) {
        this.daoLibro = libroDao;
    }

    public Libro createLibro(String isbn, String nombre, String autor, String editorial) {
        
        Libro libro = daoLibro.findByIsbn(isbn);
       
        if (libro == null) { 
            libro = new Libro();
            libro.setNombre(nombre);
            libro.setAutor(autor);
            libro.setIsbn(isbn);
            libro.setEditorial(editorial);

            int id = daoLibro.createLibro(libro);
            libro.setId(id);
            System.out.println("\n Libro creado con ID: " + id);
        } else {
            System.out.println("\n ISBN ya existe en la base de datos: " + isbn);
            return null; 
        }
        return libro;
    }

    public List<Libro> obtenerTodosLosLibros() {
        return daoLibro.findAll();
    }

    public Libro obtenerLibroPorId(int id) {
        return daoLibro.findById(id);
    }

    public Libro obtenerLibroPorNombre(String nombre) {
        return daoLibro.findByNombre(nombre);
    }

    public boolean eliminarLibro(int id) {
        return daoLibro.deleteLibro(id);
    }

    public Libro actualizarLibro(Libro libro) {
        return daoLibro.updateLibro(libro);
    }

}

