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
public class AppRuntime {
    
    private int status;
    private final SGBD sgbd;
    private Database connectedDatabase;
    private final InterfaceBuilder interfaceBuilder;

    public AppRuntime() {
        status = 0;
        sgbd = new SGBD();
        interfaceBuilder = new InterfaceBuilder();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public SGBD getSgbd() {
        return sgbd;
    }

    public Database getConnectedDatabase() {
        return connectedDatabase;
    }

    public void setConnectedDatabase(Database connectedDatabase) {
        this.connectedDatabase = connectedDatabase;
    }

    public InterfaceBuilder getInterfaceBuilder() {
        return interfaceBuilder;
    }
    
}
