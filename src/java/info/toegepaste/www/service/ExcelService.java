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
    public String printExcel();
    public void upload();
    public Part getFile();
    public void setFile(Part file);
}
