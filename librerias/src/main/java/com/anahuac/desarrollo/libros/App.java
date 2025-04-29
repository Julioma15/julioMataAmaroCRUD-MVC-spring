package com.anahuac.desarrollo.libros;


import com.anahuac.desarrollo.persistance.DAOLibro;
import com.anahuac.desarrollo.persistance.IDAOLibro;
import com.anahuac.desarrollo.service.LibroService;
import com.anahuac.desarrollo.presentation.LibroCreate;

public class App {
    public static void main(String[] args) {
    	IDAOLibro daoLibro = new DAOLibro();
    	LibroService servicio = new LibroService(daoLibro);
        
    	LibroCreate formulario = new LibroCreate(daoLibro,servicio);
    	formulario.setSize(600,200);
    	formulario.setVisible(true);
    }
    
}