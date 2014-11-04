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
@ManagedBean(name="excelController")
public class ExcelController {
    @EJB
    private ExcelService excelservice;
    
    public void upload() {
    excelservice.upload();
  }
 
    public void createExcel(){
        excelservice.createExcel();
    }
}
