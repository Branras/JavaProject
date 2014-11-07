/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.model.*;
import info.toegepaste.www.service.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author brams
 */
@ManagedBean(name="resultatenController")
public class ResultatenController {
    private List<Klas> klassen;
    private List<Test> testen;
    private List<Vak> vakken;
    private List<Student> studenten;
    
    @EJB
    private ResultatenService resultatenservice;
    
    @PostConstruct
    public void init() {
        klassen = resultatenservice.getAllKlassen();
        testen = resultatenservice.getAllTesten();
        vakken = resultatenservice.getAllVakken();
    }

    public List<Klas> getKlassen() {
        return klassen;
    }

    public void setKlassen(List<Klas> klassen) {
        this.klassen = klassen;
    }

    public List<Test> getTesten() {
        return testen;
    }

    public void setTesten(List<Test> testen) {
        this.testen = testen;
    }

    public List<Vak> getVakken() {
        return vakken;
    }

    public void setVakken(List<Vak> vakken) {
        this.vakken = vakken;
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }
    
    
    
}
