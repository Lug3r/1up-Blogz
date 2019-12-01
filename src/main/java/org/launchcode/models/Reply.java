package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Reply {

    @Id
    @GeneratedValue
    private int id;




    @Size(min = 3, max = 500)
    private String reply;

    public Reply() { }

    public Reply(String reply) {

        this.reply = reply;

    }

    public int getId() {
        return id;
    }

    public String getReply() {
        return reply;
    }



    public void setReply(String reply) {

        this.reply = reply;

    }
}
