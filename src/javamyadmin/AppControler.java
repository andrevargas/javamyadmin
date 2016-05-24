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
    
    private Database connectedDatabase;
    
    public void start()
    {
        this.status = 1;
        
        SGBD sgbd = new SGBD();
        sgbd.startService();
        
        InterfaceBuilder interfaceBuilder = new InterfaceBuilder();
        
        interfaceBuilder.renderWelcomeScreen(sgbd.getVersion());
        
        while(this.status == 1){
            
            String command = interfaceBuilder.getInputData();
            
            if (command.equals("help")) {
                interfaceBuilder.renderHelpScreen();
            }
            else if (command.equals("lsdb")) {
                if (sgbd.getDatabases().isEmpty()) {
                    interfaceBuilder.renderEmptySGBDMessage();
                }
                else{
                    interfaceBuilder.renderDatabaseList(sgbd);
                }
            }
            else if(command.contains("connect")){
                
                int begin = command.indexOf(" ") + 1;
                int end = command.length();
                String search = command.substring(begin, end);
                
                Database database = sgbd.findDatabaseByName(search);
                
                if (database != null) {
                    this.connectedDatabase = database;
                    interfaceBuilder.renderFoundDatabaseMessage(connectedDatabase.getName());
                }
                else{
                    interfaceBuilder.renderNotFoundDatabaseMessage(search);
                }
            }
            else if (command.equals("lstbl")) {
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
            else if (command.contains("show")) {
                
                int begin = command.indexOf(" ") + 1;
                int end = command.length();
                String search = command.substring(begin, end);
                
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
            else if (command.equals("exit")) {
                this.status = 0;
            }
            else {
                interfaceBuilder.renderCommandNotFoundMessage(command);
            }
            
        }
        
    }
    
}
