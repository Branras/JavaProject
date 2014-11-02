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
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Docent> getAllDocenten() {
        Query q = em.createQuery("SELECT d FROM Docent d ORDER BY d.familienaam ASC, d.naam ASC");
        return (List<Docent>) q.getResultList();          
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void insertDocent(String familienaam, String voornaam, String login, String pass)
    {
        Query q = em.createQuery("INSERT INTO Docent VALUES (?,?,?,?)");
        q.setParameter(1, familienaam);
        q.setParameter(2, login);
        q.setParameter(3, voornaam);
        q.setParameter(4, pass);
        q.executeUpdate();
    }
}
