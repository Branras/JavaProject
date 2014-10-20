/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.model.*;
import info.toegepaste.www.service.*;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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

    public String dologin() {
        docent = getDocent(login, pass);
        if (docent != null) {
            return "home";
        } else {
            error = "You're username or password isn't valid";
            return "login";
        }

    }
}
