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
public class Menu {
    
    private String title;
    private ArrayList<String> options;

    public Menu(String title, ArrayList<String> options) {
        this.title = title;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
    
}
