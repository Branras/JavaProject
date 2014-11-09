/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import java.util.Date;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.Query;
import javax.servlet.http.Part;

/**
 *
 * @author Mathias
 */
public interface ExcelService {
   
    public void insertScore(int studentennummer, int testId, int score, int maxScore);
    public void insertTest(int vakId, String naam, int maxScore);
    public int getVakId(String naam);
    public int getTestId(String naam);
    public int getKlasId(String naam);
    public String upload(Part file);
}
