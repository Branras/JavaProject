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

/**
 *
 * @author brams
 */
@ManagedBean(name="loginController")
public class LoginController {
    private Docent docent;
    
    @EJB
    private LoginService loginservice;

    public Docent getDocent(String login, String pass) {
        return loginservice.getLogin(login, pass) ;
    }

    
    
}
