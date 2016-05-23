/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.util.ArrayList;

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
    
    public void renderMenu(Menu menu) 
    {
        writer.write(menu.getTitle());
        for (String option : menu.getOptions()) {
            writer.write(menu.getOptions().indexOf(option) + 1 + ". " + option);
        }
        
    }
    
    public void renderDatabaseList(SGBD sgbd)
    {
        String[] header = {"Bancos de dados"};
        writer.write("\n", false);
        writer.writeTable(header, sgbd.getDatabasesAsMatrix(), -1);
    }
    
    public void buildTableSelectMenu(Database database)
    {
        ArrayList<String> options = new ArrayList<>();
        
        for (Table table : database.getTables()) {
            options.add(table.getName());
        }
        
        Menu menu = new Menu("Selecione uma tabela: ", options);
        renderMenu(menu);
        
    }
    
    public String getInputData() 
    {
        writer.write("javamyadmin> ", false);
        return reader.read();
    }
    
    public void renderWelcomeScreen()
    {
        String welcomeText = "Bem vindo ao JavaMyAdmin!\n"
                + "Desenvolvido por: André L. Vargas e Cristiano Winter.\n"
                + "Versão: 0..0.0.0.0..........1 pre-alpha\n\n"
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
    
    public void renderFoudDatabaseMessage(String text)
    {
        writer.write("Conectado ao banco '" + text + "'");
    }
    
    public void renderNotFoundDatabaseMessage(String text)
    {
        writer.write("Banco de dados '" + text + "' não encontrado");
    }
    
}
