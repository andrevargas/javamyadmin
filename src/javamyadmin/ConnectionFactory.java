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
//        Esta url com parâmetros diferentes foi necessário para rodas sem exceções na minha máquina.
//        Também foi necessário inserir comando "set @@global.show_compatibility_56=ON;" no MySQL.
//        String url ="jdbc:mysql://localhost?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
        String url = "jdbc:mysql://localhost";
        
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");
        
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
