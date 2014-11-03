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
        Query q = em.createNamedQuery("Student.findAllMetKlas");
        return (List<Student>) q.getResultList();          
    }
}
