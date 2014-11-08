/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.service.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author brams
 */
@ManagedBean(name="ExcelController")
public class ExcelController {
    @EJB
    private ExcelService excelservice;
    private StudentService studentservice;
    public Part file;
    public String fileContent;
    public String test;
    public int cellNr;
    
    private String infoCel;
    private int scoresTeller = 1;
    
    public int cellInt;
    public String cellString;
    public HSSFWorkbook workbook;
    
    public String klasDebug;
    public String vakDebug;
    public String testDebug;
    public int totaalDebug;
    public List<Integer> studentennrDebug = new ArrayList<Integer>();
    public List<String> naamDebug = new ArrayList<String>();
    public List<Integer> scoreDebug = new ArrayList<Integer>();
    
    
    public void upload() {
    try {
        //lees de content stream in naar de hssfworkbook
      workbook = new HSSFWorkbook(file.getInputStream());
      //kies de juiste pagina (eerste)
      HSSFSheet sheet = workbook.getSheetAt(0);
      
      Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //Leest elke horizontale lijn van links naar rechts uit in de console
                Iterator<Cell> cellIterator = row.cellIterator();
                
                cellNr = 0;
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    cellNr++;
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue());
                            cellInt = (int) cell.getNumericCellValue();
                            
                            
                            if(infoCel.equals("totaal")){
                                totaalDebug = cellInt;
                            }else{
                                if(scoresTeller == 1){
                                            studentennrDebug.add(cellInt);
                                            scoresTeller++;
                                        }else{
                                            scoreDebug.add(cellInt);
                                            scoresTeller = 1;
                                        }
                            }   
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue());
                            cellString = cell.getStringCellValue();
                          
                            //Als er een titel in de cel zit en steek in infoCel
                            if(cellString.toLowerCase().equals("vak") || cellString.toLowerCase().equals("klas") || cellString.toLowerCase().equals("test") || cellString.toLowerCase().equals("totaal") || cellString.toLowerCase().equals("score")){
                                infoCel = cellString.toLowerCase();
                            }else{
                                //inhoud in de cell
                                switch(infoCel){
                                    case "klas":
                                        klasDebug = cellString;
                                        break;
                                    case "vak":
                                        vakDebug = cellString;
                                        break;
                                    case "test":
                                        testDebug = cellString;
                                        break;
                                    case "score":
                                        naamDebug.add(cellString);
                                        scoresTeller++;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        break;
                    }
                }              
                System.out.println("");
            }
      test = "2";
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
