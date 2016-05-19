/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import com.bethecoder.ascii_table.ASCIITable;

/**
 *
 * @author andre
 */
public class ConsoleWriter {
    
    public void write(String text) 
    {
        System.out.println(text);
    }
    
    public void writeTable(String[] header, String[][] data) {
        ASCIITable.getInstance().printTable(header, data);
    }
    
}
