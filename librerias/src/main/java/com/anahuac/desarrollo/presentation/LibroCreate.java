package com.anahuac.desarrollo.presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import com.anahuac.desarrollo.persistance.IDAOLibro;
import com.anahuac.desarrollo.service.LibroService;
import com.anahuac.desarrollo.entities.Libro;

public class LibroCreate extends JFrame implements ActionListener {
	
    JButton b1,b2;  
    JPanel newPanel;  
    JLabel nombreLabel, autorLabel, isbnLabel,editorialLabel;  
    final JTextField  nombreTxt, autorTxt, editorialTxt,isbnTxt;  
    IDAOLibro daoLibro;
    LibroService  servicio;
    
      
      
    public LibroCreate(IDAOLibro dao, LibroService servicio)  
    {  
    	
          this.daoLibro= dao;
          this.servicio=servicio;
         
        nombreLabel = new JLabel();  
        nombreLabel.setText("Titulo");     

         
        nombreTxt = new JTextField(50);    
  
          
       autorLabel = new JLabel();  
        autorLabel.setText("Autor");     
          
        
        autorTxt = new JTextField(50);     
        
          
        isbnLabel = new JLabel();  
        isbnLabel.setText("ISBN");       
          

        isbnTxt = new JTextField(50);     
       
          
      editorialLabel = new JLabel();  
      editorialLabel.setText("Editorial");      
         
       
      editorialTxt = new JTextField(50);     

          
        b1 = new JButton("SUBMIT"); 
        b2 = new JButton("CANCEL");
          
         
        newPanel = new JPanel(new GridLayout(5, 2));  
        newPanel.add(nombreLabel);      
        newPanel.add(nombreTxt); 
        newPanel.add(autorLabel);    
        newPanel.add(autorTxt); 
        newPanel.add(isbnLabel);      
        newPanel.add(isbnTxt); 
        newPanel.add(editorialLabel);  
        newPanel.add(editorialTxt);  
        newPanel.add(b1);             
        newPanel.add(b2);
          
           
        add(newPanel, BorderLayout.CENTER);  
          
          
        b1.addActionListener(this);     
        setTitle("Librerio");          
    }  
      
    
    public void actionPerformed(ActionEvent ae) {
        String isbn = isbnTxt.getText().trim();
        
        Libro l = servicio.createLibro(isbn, nombreTxt.getText(), autorTxt.getText(), editorialTxt.getText());

        if (l != null) {
            JOptionPane.showMessageDialog(this, "\n El id del libro es: " + l.getId());
        } else {
            JOptionPane.showMessageDialog(this, "\n Ya existe este libro con el ISBN: " + isbn);
        }
    }


}

