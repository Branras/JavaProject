/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.service;
import javax.ejb.Stateless;


/**
 *
 * @author Mathias
 */
@Stateless
public class ExcelServiceImpl implements ExcelService{
    @Override
    public String printExcel(){
        return "Test";
    }
    
}
