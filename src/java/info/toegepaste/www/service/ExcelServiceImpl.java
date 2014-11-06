/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.Part;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;


/**
 *
 * @author Mathias
 */
@Stateless
public class ExcelServiceImpl implements ExcelService{
    @PersistenceContext
    private EntityManager em;
    
   @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void insertScore(int studentennummer, int testId, int score, int maxScore)
    {
        try{
        Query q = em.createNativeQuery("INSERT INTO score (maxaantalpunten, score, studentid, testid) VALUES (?,?,?,?)");
        q.setParameter(1, maxScore);
        q.setParameter(2, score);
        q.setParameter(3, studentennummer);
        q.setParameter(4, testId);
        q.executeUpdate();
        }catch(Exception e){}
    }
}
