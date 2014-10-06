/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.db;

import java.util.*;
import java.sql.*;
import info.toegepaste.www.beans.*;

/**
 *
 * @author brams
 */
public class DADocent {
    
    private Connection connection = null;
    
    //constructor met 4 parameters
    public DADocent(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
}
