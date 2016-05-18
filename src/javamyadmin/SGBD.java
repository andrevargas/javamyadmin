/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andre
 */
public class SGBD {
    
    private String name = "";
    private ArrayList<Database> databases = new ArrayList<>();
    private final Connection connection;

    public SGBD() {
        connection = ConnectionFactory.getConnection();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Database> getDatabases() {
        return databases;
    }

    public void setDatabases(ArrayList<Database> databases) {
        this.databases = databases;
    }
    
    /**
     * Starts the SGBD service
     */
    public void startService() {
        
        try {
            loadDatabases();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public void loadDatabases() throws SQLException
    {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet catalogs = databaseMetaData.getCatalogs();
        
        //Iterate over all databases in SGBD
        while (catalogs.next()) {

            //Create a new Database instance and set its attributes
            Database database = new Database();
            database.setName(catalogs.getString("TABLE_CAT"));
            
            //Load all database tables
            ArrayList<Table> tables = loadTables(databaseMetaData, database.getName());
            
            //Add them to Database object
            database.setTables(tables); 
            databases.add(database);

        }
    }
    
    public ArrayList<Table> loadTables(DatabaseMetaData databaseMetaData, String databaseName) throws SQLException
    {
        //Get all tables in database
        ResultSet tablesData = databaseMetaData.getTables(databaseName, null, null, null);

        //Holds the list of all tables
        ArrayList<Table> tables = new ArrayList<>();

        //Iterate over all tables in database
        while (tablesData.next()) {

            //Create a new Table instance
            Table table = new Table();
            table.setName(tablesData.getString("TABLE_NAME"));

            //Execute SQL command to populate ResultSet
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM " + databaseName + "." + table.getName());
            ResultSetMetaData tableMetaData = result.getMetaData();

            //Holds the values of the table header
            List<String> header = new ArrayList<>();

            //Iterate over table metadata to get the names and types of all columns
            for (int i = 1; i <= tableMetaData.getColumnCount(); i++) {
                header.add(tableMetaData.getColumnName(i) + " (" + tableMetaData.getColumnTypeName(i) + ")");
            }

            //Holds the rows of the table
            List<List<String>> rows = new ArrayList<>();

            //Holds the cells of the table
            List<String> cells = null;
            String data = null;

            //Iterate over all table rows
            while (result.next()) {

                cells = new ArrayList<>();

                //Iterate over all cells in the row
                for (int j = 1; j <= tableMetaData.getColumnCount(); j++) {
                    if (result.getObject(j) != null) {
                        data = result.getObject(j).toString();
                    }
                    cells.add(data);
                }

                //Append cells to row
                rows.add(cells);
            }

            //Set header and rows to in table
            table.setHeader(header);
            table.setRows(rows);

            //Add table to list
            tables.add(table);

        }
        
        return tables;
    }
    
}
