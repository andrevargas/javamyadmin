/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamyadmin;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class ConsoleInputReader {
    
    public String read()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
}
