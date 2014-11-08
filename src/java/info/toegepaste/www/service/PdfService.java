/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import info.toegepaste.www.model.Score;
import info.toegepaste.www.model.Student;
import info.toegepaste.www.model.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;




/**
 *
 * @author bens
 */
public interface PdfService {
    public void genereerPdfTest() throws DocumentException, IOException;
    public void exportPdf(File temp) throws FileNotFoundException, IOException;
    public List<Score> getAllScores();
    public Student getStudentById(int id);
    public Test getTestById(int id);
}
