/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import javamyadmin.commands.Command;
import javamyadmin.commands.CommandFactory;

/**
 *
 * @author andre
 */
public class AppControler {
    
    public void start()
    {
        
        AppRuntime app = new AppRuntime();
        InterfaceBuilder interfaceBuilder = app.getInterfaceBuilder();
        SGBD sgbd = app.getSgbd();
        
        interfaceBuilder.renderWelcomeScreen(sgbd.getVersion());
        app.setStatus(1);
        
        while(app.getStatus() == 1){
            
            String input = interfaceBuilder.getInputData();
            Command command = CommandFactory.createCommand(input);
            command.execute(app);
            
        }
        
    }
    
}
