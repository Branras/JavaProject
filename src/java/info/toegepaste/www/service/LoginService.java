/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import info.toegepaste.www.model.Docent;

/**
 *
 * @author brams
 */
public interface LoginService {
    
    public Docent getLogin(String login, String pass);
}
