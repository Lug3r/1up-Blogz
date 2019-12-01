package org.launchcode.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;



    @NotNull
    @Size(min = 3, max = 500)
    private String description;

    @NotNull
    @Size(min = 3, max = 500)
    private String preference;

    @NotNull
    @Size(min = 3, max = 500)
    private String game;





    public Post() { }

    public Post(String description, String preference, String game) {

        this.description = description;
        this.preference = preference;
        this.game = game;

    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPreference() {
        return preference;
    }

    public String getGame() {
        return game;
    }

    public void setDescription(String description) {

        this.description = description;
    }
    public void setPreference(String preference) {

        this.preference = preference;
    }
    public void setGame(String game) {

        this.game = game;
    }
}