/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.service.*;
import java.io.IOException;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

/**
 *
 * @author brams
 */
@ManagedBean(name="ExcelController")
public class ExcelController {
    @EJB
    private ExcelService excelservice;
    public Part file;
    public String fileContent;
    
    public void upload() {
    try {
      fileContent = new Scanner(file.getInputStream())
          .useDelimiter("\\A").next();
    } catch (IOException e) {
      // Error handling
    }
  }
 
    public void createExcel(){
        excelservice.createExcel();
    }
    public Part getFile() {
    return file;
  }
 
  public void setFile(Part file) {
    this.file = file;
  }
}
