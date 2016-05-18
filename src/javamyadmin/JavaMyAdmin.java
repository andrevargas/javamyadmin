/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import com.bethecoder.ascii_table.ASCIITable;

/**
 *
 * @author 5108055
 */
public class JavaMyAdmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SGBD sgbd = new SGBD();
        sgbd.startService();

//        String [] header = { "User Name", "Salary", "Designation", "Address", "Lucky#" };
//        
//        String[][] data = {
//            { "Ram", "2000", "Manager", "#99, Silk board", "1111"  },
//            { "Sri", "12000", "Developer", "BTM Layout", "22222" },
//            { "Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333" },
//            { "Anu", "132000", "QA", "#22, Vizag", "4444444" },
//            { "Sai", "62000", "Developer", "#3-3, Kakinada"  },
//            { "Venkat", "2000", "Manager"   },
//            { "Raj", "62000"},
//            { "BTC"},
//        };
//        
//        ASCIITable.getInstance().printTable(header, data);

        String[] header = sgbd.getDatabases().get(0).getTables().get(0).getHeaderAsArray();
        String[][] data = sgbd.getDatabases().get(0).getTables().get(0).getRowsAsArray();
        
        System.out.println("Connected on database" + sgbd.getDatabases().get(0).getName());
        System.out.println("Table: " + sgbd.getDatabases().get(0).getTables().get(0).getName());
        
        ASCIITable.getInstance().printTable(header, data);
        
    }
    
}
