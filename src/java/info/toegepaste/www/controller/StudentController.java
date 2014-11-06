/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.model.*;
import info.toegepaste.www.service.StudentService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author brams
 */
@ManagedBean(name="studentController")
public class StudentController {
    private List<Student> studenten;
    private List<Klas> klassen;
    
    //inserten
    private String naam;
    
    @EJB
    private StudentService studentservice;
    
    @PostConstruct
    public void init() {
        studenten = studentservice.getAllStudenten();
        klassen = studentservice.getAllKlassen();
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }

    public List<Klas> getKlassen() {
        return klassen;
    }

    public void setKlassen(List<Klas> klassen) {
        this.klassen = klassen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    public void insertKlas()
    {
        
    }
}
