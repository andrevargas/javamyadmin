/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.util.ArrayList;

/**
 *
 * @author 5108055
 */
public class Database {
    
    private String name = "";
    private ArrayList<Table> tables = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }
    
    public String[][] getTablesAsMatrix()
    {
        String[][] rows = new String[tables.size()][];
        
        for (int i = 0; i < tables.size(); i++) {
            String[] cells = {tables.get(i).getName()};
            rows[i] = cells;
        }
        
        return rows;
    }
    
}
