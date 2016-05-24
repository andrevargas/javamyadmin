/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
        String url = "jdbc:mysql://localhost";
        
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");
        
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}
