/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin.commands;

import javamyadmin.AppRuntime;
import javamyadmin.Database;
import javamyadmin.InterfaceBuilder;
import javamyadmin.SGBD;

/**
 *
 * @author andre
 */
public class ConnectCommand implements Command{
    
    private final String action;

    public ConnectCommand(String action) {
        this.action = action;
    }
    
    @Override
    public void execute(AppRuntime appRuntime) {
        
        InterfaceBuilder interfaceBuilder = appRuntime.getInterfaceBuilder();
        SGBD sgbd = appRuntime.getSgbd();
        
        int begin = action.indexOf(" ") + 1;
        int end = action.length();
        String search = action.substring(begin, end);

        Database database = sgbd.findDatabaseByName(search);

        if (database != null) {
            appRuntime.setConnectedDatabase(database);
            interfaceBuilder.renderFoundDatabaseMessage(appRuntime.getConnectedDatabase().getName());
        }
        else{
            interfaceBuilder.renderNotFoundDatabaseMessage(search);
        }
    }
    
}
