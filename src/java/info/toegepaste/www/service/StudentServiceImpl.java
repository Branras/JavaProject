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
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author brams
 */
@Stateless
public class StudentServiceImpl implements StudentService {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Student> getAllStudenten() {
        Query q = em.createNamedQuery("Student.findAll");
        return (List<Student>) q.getResultList();          
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Klas> getAllKlassen() {
        Query q = em.createNamedQuery("Klas.findAll");
        return (List<Klas>) q.getResultList();          
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void insertKlas(String naam) {
        try{
        Query q = em.createNativeQuery("INSERT INTO klas (naam) VALUES (?)");
        q.setParameter(1, naam);
        q.executeUpdate();
        }catch(Exception e){}
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void insertStudent(String familienaam, String voornaam, String Email, int nummer, int klasId) {
        try{
        Query q = em.createNativeQuery("INSERT INTO student (email, familienaam, nummer, voornaam, klasid) VALUES (?,?,?,?,?)");
        q.setParameter(1, Email);
        q.setParameter(2, familienaam);
        q.setParameter(3, nummer);
        q.setParameter(4, voornaam);
        q.setParameter(5, klasId);
        q.executeUpdate();
        }catch(Exception e){}
    }
}
