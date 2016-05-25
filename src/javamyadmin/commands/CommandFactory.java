/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin.commands;


/**
 *
 * @author andre
 */
public class CommandFactory {
    
    private static Command command;
    
    public static Command createCommand(String action)
    {
        
        if (action.equals("help")) {
            command = new HelpCommand();
        }
        else if (action.equals("lsdb")) {
            command = new ListDatabaseCommand();
        }
        else if (action.contains("connect")) {
            command = new ConnectCommand(action);
        }
        else if (action.equals("lstbl")) {
            command = new ListTableCommand();
        }
        else if (action.contains("show")) {
            command = new ShowTableCommand(action);
        }
        else if (action.equals("exit")) {
            command = new ExitCommand();
        }
        else {
            command = new NotFoundCommand(action);
        }
        
        return command;
        
    }
    
}
