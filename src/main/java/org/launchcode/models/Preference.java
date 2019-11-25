package org.launchcode.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Preference {


    @Id
    @GeneratedValue
    private int id;


    private String console;

    public Preference() {

    }

    public String getConsole() {
        return console;
    }
    public void setConsole(String console) {
        this.console = console;
    }
}
