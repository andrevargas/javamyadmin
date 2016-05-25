/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin.commands;

import javamyadmin.AppRuntime;
import javamyadmin.InterfaceBuilder;
import javamyadmin.SGBD;

/**
 *
 * @author andre
 */
public class ListDatabaseCommand implements Command{

    @Override
    public void execute(AppRuntime appRuntime)
    {
        
        InterfaceBuilder interfaceBuilder = appRuntime.getInterfaceBuilder();
        SGBD sgbd = appRuntime.getSgbd();
        
        if (sgbd.getDatabases().isEmpty()) {
            interfaceBuilder.renderEmptySGBDMessage();
        }
        else{
            interfaceBuilder.renderDatabaseList(sgbd);
        }
        
    }
    
}
