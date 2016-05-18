/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 5108055
 */
public class ConnectionFactory {
    
    /**
     * @return Connection
     */
    public static Connection getConnection()
    {
        String url ="jdbc:mysql://localhost";
        String user = "root";
        String password = "";
        
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}