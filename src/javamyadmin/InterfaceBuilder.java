/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class InterfaceBuilder {
    
    public void buildMenu(String title, ArrayList<String> options) 
    {
        ConsoleWriter writer = new ConsoleWriter();
        
        writer.write(title);
        
        for (String option : options) {
            writer.write(option);
        }
        
    }
    
    public void buildDatabaseSelectMenu(SGBD sgbd)
    {
        String title = "Selecione um banco de dados";
        
        ArrayList<Database> databases = sgbd.getDatabases();
        
        for (Database database : databases) {
            System.out.println(databases.indexOf(database));
        }
        
    }
    
}
