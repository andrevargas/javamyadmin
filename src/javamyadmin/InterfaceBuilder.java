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
    
    public void renderMenu(Menu menu) 
    {
        ConsoleWriter writer = new ConsoleWriter();
        
        writer.write(menu.getTitle());
        for (String option : menu.getOptions()) {
            writer.write(menu.getOptions().indexOf(option) + 1 + ". " + option);
        }
        
    }
    
    public void buildDatabaseSelectMenu(SGBD sgbd)
    {
        ArrayList<String> options = new ArrayList<>();
        
        for (Database database : sgbd.getDatabases()) {
            options.add(database.getName());
        }
        
        Menu menu = new Menu("Selecione o banco de dados: ", options);
        renderMenu(menu);
        
    }
    
}
