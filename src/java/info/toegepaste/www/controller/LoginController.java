/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import info.toegepaste.www.model.*;
import info.toegepaste.www.service.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author brams
 */
@ManagedBean(name = "loginController")
public class LoginController {

    @EJB
    private LoginService loginservice;

    private Docent docent;

    //login
    private String login;
    private String pass;

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

    public Docent getDocent(String login, String pass) {
        return loginservice.getLogin(login, pass);
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public RedirectView dologin() {
        //Docent docent = getDocent(login, pass);
        
       // RedirectView redirectView = new RedirectView();
       // redirectView.setUrl("http://www.yahoo.com");
      //  return redirectView;
        return new RedirectView("/mySuperSexyStuff");
    }
}
