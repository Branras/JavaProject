/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import info.toegepaste.www.model.Docent;
import info.toegepaste.www.model.Student;
import info.toegepaste.www.service.DocentService;
import info.toegepaste.www.service.StudentService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author brams
 */
@ManagedBean(name="pdfController")
public class PdfController {
    public static final String RESULT
            = "D://hello.pdf";

    public static void Write() throws DocumentException, IOException {
        
        new PdfController().createPdf(RESULT);
    }

    private List<Student> studenten;
    
    @EJB
    private StudentService studentservice;
    
    @PostConstruct
    public void init() {
        studenten = studentservice.getAllStudenten();
    }
    
    public List<Student> getStudenten() {
        return studenten;
    }
    
    public void createPdf(String filename)
            throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
//        for (Student student : studenten ) {
//            document.add(new Paragraph(student.toString()));
//        }
        
        document.add(new Paragraph("Hello World!"));
        // step 5
        document.close();
    }
}
