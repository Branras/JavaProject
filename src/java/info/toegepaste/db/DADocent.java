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
    
    public Docent getLogin(String login, String pass) {
        Docent docent = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM docent WHERE login=? AND pass=? ");
            statement.setString(1, login);
            statement.setString(2, pass);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                docent = new Docent();
                docent.setId(resultSet.getInt("docent.id"));
                docent.setNaam(resultSet.getString("docent.naam"));
                docent.setFamilienaam(resultSet.getString("land.familienaam"));
                docent.setLogin(resultSet.getString("docent.login"));
                docent.setPass(resultSet.getString("docent.pass"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
            }
        }
        return docent;
    }
}
