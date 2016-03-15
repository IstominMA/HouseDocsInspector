package com.example.login;


import java.util.Date;

public class Document {

    private String name;
    private Date creationDate;
    private String info;

    private Document() {};

    public Document (String name, Date creationDate, String info) {

        this.name = name;
        this.creationDate = creationDate;
        this.info = info;

    }


    public String getName(){
        return name;
    }
    public Date getCreationDate(){
        return  creationDate;
    }
    public String getInfo(){
        return  info;
    }

}

