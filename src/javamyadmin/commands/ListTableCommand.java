/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin.commands;

import javamyadmin.AppRuntime;
import javamyadmin.Database;
import javamyadmin.InterfaceBuilder;

/**
 *
 * @author andre
 */
public class ListTableCommand implements Command{

    @Override
    public void execute(AppRuntime appRuntime) {
        
        Database connectedDatabase = appRuntime.getConnectedDatabase();
        InterfaceBuilder interfaceBuilder = appRuntime.getInterfaceBuilder();
        
        if (connectedDatabase != null) {
            if (connectedDatabase.getTables().isEmpty()) {
                interfaceBuilder.renderEmptyDatabaseMessage(connectedDatabase.getName());
            }
            else{
                interfaceBuilder.renderTableList(connectedDatabase);
            }
        }
        else {
            interfaceBuilder.renderNotConnectedToDatabaseMessage();
        }
        
    }
    
}
