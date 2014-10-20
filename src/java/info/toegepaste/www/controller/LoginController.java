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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 *
 * @author brams
 */
@ManagedBean(name = "loginController")
@SessionAttributes("docentsession")
public class LoginController {

    @EJB
    private LoginService loginservice;
    private Docent docent;

    //login
    private String login;
    private String pass;
    private String error = "";

    //test
    @RequestMapping(method = GET)
    public String get(Model model) {
        if (!model.containsAttribute("docentsession")) {
            model.addAttribute("docentsession", new Docent());
        }
        return "docentsession";
    }

    // Obtain 'mycounter' object for this user's session and increment it
    @RequestMapping(method = POST)
    public String post(@ModelAttribute("docentsession") Docent docent) {
        
        return "home";
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Docent getDocent(String login, String pass) {
        return loginservice.getLogin(login, pass);
    }

    public String dologin() {
        docent = getDocent(login, pass);
        if (docent != null) {

            return "home";
        } else {
            error = "Your username or password is not valid!";
            return "login";
        }

    }
}
