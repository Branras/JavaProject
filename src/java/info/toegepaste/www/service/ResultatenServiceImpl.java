/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import info.toegepaste.www.model.*;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.UserTransaction;

/**
 *
 * @author brams
 */
@Stateless
public class ResultatenServiceImpl implements ResultatenService{
    @PersistenceContext
    private EntityManager em;
    @PersistenceUnit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaProjectPU");
    
    @Resource
        UserTransaction ut;
    
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
        Test test = new Test();
        test.setTestid(testId);
        Query q = em.createNamedQuery("Score.findScoresByTest");
        q.setParameter("testid", test);
        return (List<Score>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Score> getScoresByKlas(int klasId) {
        Query q = em.createNamedQuery("Score.findScoresByKlas");
        q.setParameter("klasid", klasId);
        return (List<Score>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Score> getScoresByVak(int vakId) {
        Vak vak = new Vak();
        vak.setVakid(vakId);
        Query q = em.createNamedQuery("Score.findScoresByVak");
        q.setParameter("vakid", vak);
        return (List<Score>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Score> getScoresByStudent(int studentId) {
        Student student = new Student();
        student.setStudentid(studentId);
        Query q = em.createNamedQuery("Score.findScoresByStudent");
        q.setParameter("studentid", student);
        return (List<Score>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<String> getTotaalVoorVakken(int studentId) {
        Query q = em.createNativeQuery("SELECT v.naam as vaknaam , SUM(s.score) as totaal, SUM(s.maxaantalpunten) as maximum, ROUND((SUM(s.score) /  SUM(s.maxaantalpunten)) * 100,2) as percentage FROM score s JOIN test t ON s.testid = t.testid JOIN vak v ON t.vakid = v.vakid WHERE s.studentid =? GROUP BY t.vakid");
        q.setParameter(1, studentId); 
        return (List<String>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public BigDecimal getPercentageVoorStudent(int studentId) {
        Query q = em.createNativeQuery("SELECT  ROUND((SUM(s.score) /  SUM(s.maxaantalpunten)) * 100,2) as percentage FROM score s WHERE s.studentid =?");
        q.setParameter(1, studentId);
        return (BigDecimal)q.getSingleResult();        
    }
    
    @Override
    
    public boolean updateScore(Score score){
        EntityManager em1 = emf.createEntityManager();
        
        
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        //Query q = em.createNamedQuery("Score.findByScoreid");
//        //q.setParameter("scoreid", score.getScoreid());
//        Score oldScore = em.find(Score.class, score.getScoreid());//(Score)q.getSingleResult();
//        oldScore.setScore(score.getScore());
//        oldScore.setMaxaantalpunten(score.getMaxaantalpunten());
//        oldScore.setEditable(false);
//        et.commit();
//        em1.close();
        try{
        ut.begin();
        em1.merge(score);
        em1.close();
        ut.commit();
        } catch (Exception e) {
//            ut.rollback();
        }
        
        return true;
    }
}
