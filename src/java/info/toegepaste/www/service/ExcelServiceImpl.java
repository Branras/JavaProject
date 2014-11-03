/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;
import java.io.IOException;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.servlet.http.Part;


/**
 *
 * @author Mathias
 */
@Stateless
public class ExcelServiceImpl implements ExcelService{
    private Part file;
    private String fileContent;
  
    @Override
    public String printExcel(){
        return "Test";
    }
    public void upload() {
    try {
      fileContent = new Scanner(file.getInputStream())
          .useDelimiter("\\A").next();
    } catch (IOException e) {
      // Error handling
    }
  }
 
  public Part getFile() {
    return file;
  }
 
  public void setFile(Part file) {
    this.file = file;
  }
}
