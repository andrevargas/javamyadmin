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
public class InterfaceBuilder {
    
    private final ConsoleWriter writer;
    private final ConsoleInputReader reader;

    public InterfaceBuilder() 
    {
        this.writer = new ConsoleWriter();
        this.reader = new ConsoleInputReader();
    }
    
    public void renderDatabaseList(SGBD sgbd)
    {
        String[] header = {"Bancos de dados"};
        writer.write("\n", false);
        writer.writeTable(header, sgbd.getDatabasesAsMatrix(), -1);
    }
    
    public void renderTableList(Database database)
    {
        String[] header = {"Tabelas do banco de dados '" + database.getName() + "'"};
        writer.write("\n", false);
        writer.writeTable(header, database.getTablesAsMatrix(), -1);
    }
    
    public void renderTableData(Table table){
        writer.writeTable(table.getHeaderAsArray(), table.getRowsAsArray());
    }
    
    public String getInputData() 
    {
        writer.write("javamyadmin> ", false);
        return reader.read();
    }
    
    public void renderWelcomeScreen(String version)
    {
        String welcomeText = "Bem vindo ao JavaMyAdmin!\n"
                + "Desenvolvido por: André L. Vargas e Cristiano Winter.\n"
                + "Versão do programa: 0.1.3 pre-alpha\n"
                + "Versão do servidor MySQL: " + version + "\n\n"
                + "Digite 'help' para receber ajuda!\n";
        writer.write(welcomeText);
        
    }
    
    public void renderHelpScreen()
    {
        String helpText = "\n\tComandos disponíveis:\n\n"
                + "\tlsdb\n"
                + "\t\tListar todos os bancos de dados.\n"
                + "\tconnect <dbname>\n"
                + "\t\tConectar-se a um banco de dados (substituir <dbname> pelo nome do banco desejado).\n"
                + "\tlstbl\n"
                + "\t\tListar todas as tabelas do banco atual.\n"
                + "\tshow <tablename>\n"
                + "\t\tMostrar os dados de uma tabela do banco conectado (substituir <tablename> pelo nome da tabela desejada).\n"
                + "\texit\n"
                + "\t\tSair da aplicação\n"
                + "\thelp\n"
                + "\t\tReceber ajuda\n";
                
        writer.write(helpText);
    }
    
    public void renderFoundDatabaseMessage(String text)
    {
        writer.write("Conectado ao banco de dados '" + text + "'\n");
    }
    
    public void renderNotFoundDatabaseMessage(String text)
    {
        writer.write("Banco de dados '" + text + "' não encontrado\n");
    }
    
    public void renderNotConnectedToDatabaseMessage() 
    {
        writer.write("Você não está conectado a nenhum banco de dados!\n");
    }
    
    public void renderCommandNotFoundMessage(String text)
    {
        writer.write("Comando '" + text + "' não encontrado!\n");
    }
    
    public void renderTableNotFoundMessage(String table, String database)
    {
        writer.write("Tabela '" + table + "' não encontrada no banco de dados '" + database + "'.\n");
    }
    
    public void renderEmptySGBDMessage()
    {
        writer.write("Não há nenhum banco de dados criado.\n");
    }
    
    public void renderEmptyDatabaseMessage(String text) 
    {
        writer.write("Não há nenhuma tabela cadastrada no banco '" + text + "'.\n");
    }
    
    public void renderEmptyTableMessage() 
    {
        writer.write("Nenhum registro encontrado.\n");
    }
}
