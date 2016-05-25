/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin.commands;

import javamyadmin.AppRuntime;

/**
 *
 * @author andre
 */
public class ExitCommand implements Command{

    @Override
    public void execute(AppRuntime appRuntime) {
        appRuntime.setStatus(0);
    }
    
}
