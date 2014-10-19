/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.model.Docent;
import info.toegepaste.www.service.DocentService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author brams
 */
@ManagedBean(name="docentController")
public class DocentController {
    private List<Docent> docenten;
    
    @EJB
    private DocentService docentService;
    
    public List<Docent> getDocenten() {
        return docenten;
    }

    public void setDocenten(List<Docent> docenten) {
        this.docenten = docenten;
    }
}
