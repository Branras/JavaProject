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
public class DocentServiceImpl implements DocentService{
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(REQUIRES_NEW)
    @Override
    public List<Docent> getAllDocenten() {
        Query q = em.createQuery("SELECT * FROM Docent d");
        return (List<Docent>) q.getResultList();          
    }
}