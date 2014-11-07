/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import info.toegepaste.www.model.*;
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
public class ResultatenServiceImpl implements ResultatenService{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Klas> getAllKlassen() {
        Query q = em.createNamedQuery("Klas.findAll");
        return (List<Klas>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Test> getAllTesten() {
        Query q = em.createNamedQuery("Test.findAll");
        return (List<Test>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Vak> getAllVakken() {
        Query q = em.createNamedQuery("Vak.findAll");
        return (List<Vak>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Student> getAllStudenten() {
        Query q = em.createNamedQuery("Student.findAll");
        return (List<Student>) q.getResultList();        
    }
    
    
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Score> getAllScores() {
        Query q = em.createNamedQuery("Score.findAll");
        return (List<Score>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Score> getScoresByTest(int testId) {
        Query q = em.createNamedQuery("Score.findScoresByTest");
        q.setParameter(1, testId);
        return (List<Score>) q.getResultList();        
    }
}
