/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;
import javax.ejb.Stateless;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import info.toegepaste.www.model.*;
import java.lang.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

/**
 *
 * @author bens
 */
@Stateless
public class PdfServiceImpl implements PdfService {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public List<Score> getAllScores() {
        Query q = em.createNamedQuery("Score.findAll");
        return (List<Score>) q.getResultList();        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public Student getStudentById(int id) {
        Student student = null;
        Query q = em.createNamedQuery("Student.findByStudentid");
        q.setParameter("studentid", id);
        student = (Student) q.getSingleResult();         
        return student;
    }
   
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public Test getTestById(int id) {
        Test test = null;
        Query q = em.createNamedQuery("Test.findByTestid");
        q.setParameter("testid", id);
        test = (Test) q.getSingleResult();         
        return test;
    }
    
    @Override
    public void genereerPdfTest() throws DocumentException, IOException {
        //Maak een nieuw document aan
        Document document = new Document();
 
        //Temp file aanmaken
        File temp = File.createTempFile("rapport", ".pdf");
 
        //PDF Genereren
        PdfWriter.getInstance(document, new FileOutputStream(temp.getAbsolutePath()));
 
        //Document openen
        document.open();
 
        //Inhoud toevoegen
//        document.add(new Paragraph("Rapport"));
//        document.add(new Paragraph("Test: " + getTest(testId).getNaam()));
// 
//        document.add(new Paragraph("Klas: " + getKlas(getVak(
//                getTest(testId).getVakId().intValue()).getKlasId()).getNaam()
//        ));
//        document.add(new Paragraph("Vak: " + getVak(
//                getTest(testId).getVakId().intValue()).getNaam()
//        ));
 
        PdfPTable table = new PdfPTable(3);
        table.setSpacingBefore(10.0f);
        table.addCell("Test");
        table.addCell("Student");
        table.addCell("Score");
 
        for (int i = 0; i < getAllScores().size(); i++) {
            table.addCell("" + getTestById(getAllScores().get(i).getTestid().getTestid().intValue()).getNaam() );
            table.addCell("" + getStudentById(getAllScores().get(i).getStudentid().getStudentid().intValue()).getVoornaam() + getStudentById(getAllScores().get(i).getStudentid().getStudentid().intValue()).getFamilienaam());
            table.addCell("" + getAllScores().get(i).getScore() + "/" + getAllScores().get(i).getMaxaantalpunten() );
        }
 
        document.add(table);
 
        //Document sluiten
        document.close();
 
        exportPdf(temp);
    }   
    
    @Override
    public void exportPdf(File temp) throws FileNotFoundException, IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
 
        response.setHeader("Content-Disposition", "attachment; filename=rapport.pdf");
        response.setContentLength((int) temp.length());
 
        ServletOutputStream out = null;
 
        FileInputStream input = new FileInputStream(temp);
        byte[] buffer = new byte[1024];
        out = response.getOutputStream();
        int i = 0;
        while ((i = input.read(buffer)) != -1) {
            out.write(buffer);
            out.flush();
        }
 
        fc.responseComplete();
    }
    
            
    }



