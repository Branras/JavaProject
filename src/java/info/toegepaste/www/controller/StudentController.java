/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.controller;

import info.toegepaste.www.model.*;
import info.toegepaste.www.service.StudentService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author brams
 */
@ManagedBean(name="studentController")
public class StudentController {
    private List<Student> studenten;
    
    @EJB
    private StudentService studentservice;
    
    @PostConstruct
    public void init() {
        studenten = studentservice.getAllStudenten();
    }
    
    public List<Student> getDocenten() {
        return studenten;
    }

    public void setDocenten(List<Student> studenten) {
        this.studenten = studenten;
    }
}
