/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.model.*;
import info.toegepaste.www.service.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 *
 * @author brams
 */
@ManagedBean(name = "LoginController")
public class LoginController {

    @EJB
    private LoginService loginservice;
    private Docent docent;

    //login
    private String login;
    private String pass;
    private String error = "";

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Docent getDocent(String login, String pass) {
        return loginservice.getLogin(login, pass);
    }

    public String DoLogin() {
        docent = getDocent(login, pass);
        if (docent != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("docent", docent);
            
            return "home";
        } else {
            error = "Your username or password is not valid!";
            return "index";
        }
    }
    
    public String logOut()
    {
       FacesContext context = FacesContext.getCurrentInstance();
       HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
       session.removeAttribute("docent");
       
       return "login";
    }  
}
