/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;

import info.toegepaste.www.model.*;
import java.util.List;

/**
 *
 * @author brams
 */
public interface ResultatenService {
    public List<Klas> getAllKlassen();
    public List<Test> getAllTesten();
    public List<Vak> getAllVakken();
    public List<Student> getAllStudenten();
}
