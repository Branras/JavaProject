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
    
    //toevoegen van docent
    private String voornaam;
    private String familienaam;
    private String login;
    private String pass;
    
    @EJB
    private DocentService docentService;
    
    @PostConstruct
    public void init() {
        docenten = docentService.getAllDocenten();
    }
    
    public List<Docent> getDocenten() {
        return docenten;
    }

    public void setDocenten(List<Docent> docenten) {
        this.docenten = docenten;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String insertDocent()
    {
        //TODO
        docentService.insertDocent(familienaam,voornaam, login, pass);
        return "docenten";
        
    }
}
