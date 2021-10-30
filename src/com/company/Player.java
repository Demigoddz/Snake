package com.company;

public class Player {
    private String name;
    private String login;
    private String password;
    private int record;

    public Player(){
        this.name = "";
        this.login = "";
        this.password = "";
        this.record = 0;
    }
    public Player(String name, String login, String password, int record){
        this.name = name;
        this.login= login;
        this.password = password;
        this.record = record;
    }
    public String getName(){
        return name;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRecord(int record){
        this.record = record;
    }
}

