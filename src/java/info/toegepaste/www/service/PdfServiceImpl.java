/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import info.toegepaste.www.model.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
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
    
    
    }



