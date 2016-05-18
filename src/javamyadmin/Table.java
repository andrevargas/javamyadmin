/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.util.List;

/**
 *
 * @author 5108055
 */
public class Table {
    
    private String name = "";
    private List<String> header = null;
    private List<List<String>> rows = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }
    
    public String[] getHeaderAsArray() 
    {
        String[] headerArray = new String[header.size()];
        return header.toArray(headerArray);
    }
    
    public String[][] getRowsAsArray()
    {
        String[][] rowsArray = new String[rows.size()][];
        
        for (int i = 0; i < rows.size(); i++) {
        
            List<String> cells = rows.get(i);
            String[] cellsArray = new String[cells.size()];
            
            for (int j = 0; j < cells.size(); j++) {
                cellsArray[j] = cells.get(j);
            }
            
            rowsArray[i] = cellsArray;
            
        }
        
        return rowsArray;
        
    }
    
}
