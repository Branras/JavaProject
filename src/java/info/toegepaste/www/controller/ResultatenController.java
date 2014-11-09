/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.model.*;
import info.toegepaste.www.service.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author brams
 */
@ManagedBean(name="resultatenController")
public class ResultatenController {
    private List<Klas> klassen;
    private List<Test> testen;
    private List<Vak> vakken;
    private List<Student> studenten;
    private List<Score> scores;
    
    private List<String> totalen;
    private double algemeenTotaal;
    
    //selected items
    private int selectedTestId;
    private int selectedKlasId;
    private int selectedVakId;
    private int selectedStudentId;
    
    @EJB
    private ResultatenService resultatenservice;
    
    @PostConstruct
    public void init() {
        klassen = resultatenservice.getAllKlassen();
        testen = resultatenservice.getAllTesten();
        vakken = resultatenservice.getAllVakken();
        studenten = resultatenservice.getAllStudenten();
        scores = resultatenservice.getAllScores();
    }

    public List<Klas> getKlassen() {
        return klassen;
    }

    public void setKlassen(List<Klas> klassen) {
        this.klassen = klassen;
    }

    public List<Test> getTesten() {
        return testen;
    }

    public void setTesten(List<Test> testen) {
        this.testen = testen;
    }

    public List<Vak> getVakken() {
        return vakken;
    }

    public void setVakken(List<Vak> vakken) {
        this.vakken = vakken;
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public int getSelectedTestId() {
        return selectedTestId;
    }

    public void setSelectedTestId(int selectedTestId) {
        this.selectedTestId = selectedTestId;
    }

    public int getSelectedKlasId() {
        return selectedKlasId;
    }

    public void setSelectedKlasId(int selectedKlasId) {
        this.selectedKlasId = selectedKlasId;
    }

    public int getSelectedVakId() {
        return selectedVakId;
    }

    public void setSelectedVakId(int selectedVakId) {
        this.selectedVakId = selectedVakId;
    }

    public int getSelectedStudentId() {
        return selectedStudentId;
    }

    public void setSelectedStudentId(int selectedStudentId) {
        this.selectedStudentId = selectedStudentId;
    }

    public List<String> getTotalen() {
        return totalen;
    }

    public void setTotalen(List<String> totalen) {
        this.totalen = totalen;
    }

    public double getAlgemeenTotaal() {
        return algemeenTotaal;
    }

    public void setAlgemeenTotaal(double algemeenTotaal) {
        this.algemeenTotaal = algemeenTotaal;
    }
    
    
    public void getScoresByTest()
    {
        if(selectedTestId != 0)
        scores = resultatenservice.getScoresByTest(selectedTestId);
        else scores = resultatenservice.getAllScores();
    }
    
    public void getScoresByKlas()
    {
        if(selectedKlasId != 0)
        scores = resultatenservice.getScoresByKlas(selectedKlasId);
        else scores = resultatenservice.getAllScores();
    }
    
    public void  getScoresByVak()
    {
        if(selectedVakId != 0)
        scores = resultatenservice.getScoresByVak(selectedVakId);
        else scores = resultatenservice.getAllScores();
    }
    
    public void  getScoresByStudent()
    {
        if(selectedStudentId != 0)
        scores = resultatenservice.getScoresByStudent(selectedStudentId);
        else scores = resultatenservice.getAllScores();
    }
    
    public void saveAction(Score score)
    {
        int itsfd = 2;
        resultatenservice.updateScore(score);
    }
    
    public void getTotaalVoorVakken()
    {
        if(selectedStudentId != 0)
        {
        totalen = resultatenservice.getTotaalVoorVakken(selectedStudentId);
        algemeenTotaal = resultatenservice.getPercentageVoorStudent(selectedStudentId);
        }
    }
    
}
