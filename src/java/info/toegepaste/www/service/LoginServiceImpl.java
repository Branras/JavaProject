/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import info.toegepaste.www.model.Docent;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author brams
 */
@Stateless
public class LoginServiceImpl implements LoginService{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public Docent getLogin(String login, String pass) {
        Docent docent = null;
        try{
        Query q = em.createNamedQuery("Docent.login");
        q.setParameter("login", login);
        q.setParameter("pass", pass);
        docent = (Docent) q.getSingleResult();
        }catch(Exception e){}
        
        return docent;
    }
    
}
