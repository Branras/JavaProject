/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import info.toegepaste.www.model.Klas;
import info.toegepaste.www.model.Student;
import info.toegepaste.www.model.Test;
import info.toegepaste.www.model.Vak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.Part;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Mathias
 */
@Stateless
public class ExcelServiceImpl implements ExcelService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void insertScore(int studentennummer, int testId, int score, int maxScore) {
        System.out.println("");
        try {
            Query q = em.createNativeQuery("INSERT INTO score (maxaantalpunten, score, studentid, testid) VALUES (?,?,?,?)");
            q.setParameter(1, maxScore);
            q.setParameter(2, score);
            q.setParameter(3, studentennummer);
            q.setParameter(4, testId);
            q.executeUpdate();
        } catch (Exception e) {
        }
        System.out.println("");
    }

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void insertTest(int vakId, String naam, int maxscore) {
        System.out.println("");
        try {
            Query q = em.createNativeQuery("INSERT INTO test (datum, naam, vakid, maxscore) VALUES (?,?,?,?)");
            q.setParameter(1, new Date());
            q.setParameter(2, naam);
            q.setParameter(3, vakId);
            q.setParameter(4, maxscore);
            q.executeUpdate();
            System.out.println("");
        } catch (Exception e) {
        }
    }

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public int getVakId(String naam) {
        Vak vak = null;
        try {
            Query q = em.createNamedQuery("Vak.findByNaam");
            q.setParameter("naam", naam);
            vak = (Vak) q.getSingleResult();
        } catch (Exception e) {
        }

        return vak.getVakid();
    }

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public int getTestId(String naam) {
        Test test = null;
        try {
            Query q = em.createNamedQuery("Test.findByNaam");
            q.setParameter("naam", naam);
            test = (Test) q.getSingleResult();
        } catch (Exception e) {
        }

        return test.getTestid();
    }

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public int getKlasId(String naam) {
        Klas klas = null;
        try {
            Query q = em.createNamedQuery("Klas.findByNaam");
            q.setParameter("naam", naam);
            klas = (Klas) q.getSingleResult();
        } catch (Exception e) {
            throw e;
        }

        return klas.getKlasid();
    }

    public void insertVak(String naam) {
        System.out.println("");
        try {
            Query q = em.createNativeQuery("INSERT INTO vak (naam) VALUES (?)");
            q.setParameter(1, naam);
            q.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void upload(Part file) {
        try {
        //declaratie variabelen
            //Variabelen voor tijdelijke gegevens
            int cellInt;
            String cellString;
            int cellNr;
            String infoCel = " ";
            int scoresTeller = 1;

            //debug of overzetvariabelen
            String klasDebug = " ";
            String vakDebug = " ";
            String testDebug = " ";
            int totaalDebug = 0;
            List<Integer> studentennrDebug = new ArrayList<Integer>();
            List<String> naamDebug = new ArrayList<String>();
            List<Integer> scoreDebug = new ArrayList<Integer>();

            Iterator<Row> rowIterator = null;

            if (file.getSubmittedFileName().contains("xlsx")) {
                //lees de content stream in naar de hssfworkbook
                XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                //kies de juiste pagina (eerste)
                XSSFSheet sheet = workbook.getSheetAt(0);
                rowIterator = sheet.iterator();
            } else {
                //lees de content stream in naar de hssfworkbook
                HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
                //kies de juiste pagina (eerste)
                HSSFSheet sheet = workbook.getSheetAt(0);
                rowIterator = sheet.iterator();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //Leest elke horizontale lijn van links naar rechts uit in de console
                Iterator<Cell> cellIterator = row.cellIterator();

                cellNr = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cellNr++;
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue());
                            cellInt = (int) cell.getNumericCellValue();

                            if (infoCel.equals("totaal")) {
                                totaalDebug = cellInt;
                            } else {
                                if (scoresTeller == 1) {
                                    studentennrDebug.add(cellInt);
                                    scoresTeller++;
                                } else {
                                    scoreDebug.add(cellInt);
                                    scoresTeller = 1;
                                }
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue());
                            cellString = cell.getStringCellValue();

                            //Als er een titel in de cel zit en steek in infoCel
                            if (cellString.toLowerCase().equals("vak") || cellString.toLowerCase().equals("klas") || cellString.toLowerCase().equals("test") || cellString.toLowerCase().equals("totaal") || cellString.toLowerCase().equals("score")) {
                                infoCel = cellString.toLowerCase();
                            } else {
                                //inhoud in de cell
                                switch (infoCel) {
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
            }
            System.out.println("");
            int testId = 0;
            int vakId = 0;
            int studentId = 0;

            try {
                //als er al een test is aangemaakt met die naam, voeg gewoon punten toe
                testId = getTestId(testDebug);
            } catch (Exception e) {
                try {
                    //als er al een vak is aangemaakt met die naam, voeg gewoon een vak toe
                    vakId = getVakId(vakDebug);
                } catch (Exception e1) {
                    insertVak(vakDebug);
                    vakId = getVakId(vakDebug);
                }
                //maak een nieuwe test aan
                insertTest(vakId, testDebug, totaalDebug);
                testId = getTestId(testDebug);
            }
            //Scores toevoegen
            int index = 0;
            for (int studentenNr : studentennrDebug) {
                studentId = getStudentId(studentenNr);
                insertScore(studentId, testId, scoreDebug.get(index), totaalDebug);
                index++;
            }

        } catch (IOException e) {
            // Error handling
        }
    }

    public int getStudentId(int nummer) {
        Student student = null;
        try {
            Query q = em.createNamedQuery("Student.findByNummer");
            q.setParameter("nummer", nummer);
            student = (Student) q.getSingleResult();
        } catch (Exception e) {
            throw e;
        }

        return student.getStudentid();
    }
}
