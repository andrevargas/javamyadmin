/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin.commands;

import javamyadmin.AppRuntime;
import javamyadmin.Database;
import javamyadmin.InterfaceBuilder;
import javamyadmin.Table;

/**
 *
 * @author andre
 */
public class ShowTableCommand implements Command{
    
    private final String action;

    public ShowTableCommand(String action) {
        this.action = action;
    }
    
    @Override
    public void execute(AppRuntime appRuntime) {
        
        Database connectedDatabase = appRuntime.getConnectedDatabase();
        InterfaceBuilder interfaceBuilder = appRuntime.getInterfaceBuilder();
        
        int begin = action.indexOf(" ") + 1;
        int end = action.length();
        String search = action.substring(begin, end);

        if (connectedDatabase != null) {

            Table table = connectedDatabase.findTableByName(search);

            if (table != null) {
                if(table.getRows().isEmpty()){
                    interfaceBuilder.renderEmptyTableMessage();
                }
                else{
                    interfaceBuilder.renderTableData(table);
                }
            }
            else {
                interfaceBuilder.renderTableNotFoundMessage(search, connectedDatabase.getName());
            }
        }
        else {
            interfaceBuilder.renderNotConnectedToDatabaseMessage();
        }
        
    }
    
}
