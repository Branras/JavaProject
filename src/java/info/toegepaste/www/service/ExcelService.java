/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import javax.servlet.http.Part;

/**
 *
 * @author Mathias
 */
public interface ExcelService {
   
    public void insertScore(int studentennummer, int testId, int score, int maxScore);
}
