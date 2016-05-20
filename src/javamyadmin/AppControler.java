/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

/**
 *
 * @author andre
 */
public class AppControler {
    
    /**
     * Indicates the application status
     * 0 - Stopped
     * 1 - Running
     */
    private int status = 0;
    
    public void start()
    {
        this.status = 1;
        
        SGBD sgbd = new SGBD();
        sgbd.startService();
        
        InterfaceBuilder interfaceBuilder = new InterfaceBuilder();
        
        
        while(this.status == 1){
            
            interfaceBuilder.renderWelcomeScreen();
            
            String command = interfaceBuilder.getInputData();
            
            switch(command)
            {
                case "help":
                    interfaceBuilder.renderHelpScreen();
                    break;
                case "lsdb":
                    interfaceBuilder.buildDatabaseList(sgbd);
            }
            
            this.status = 0;
            
        }
        
    }
    
}
