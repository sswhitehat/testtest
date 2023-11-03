package com.example;

public class User {
    private static int id;
    private String name;
    private String dob;
    private String f_name;
    private String c_name;

    public User(int id, String name, String dob, String f_name, String c_name){
        User.id = id;
        this.name = name;
        this.dob = dob;
        this.f_name = f_name;
        this.c_name = c_name;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return this.name;
    }

    public String getDOB(){
        return this.dob;
    }

    public String getf_name(){
        return this.f_name;
    }

    public String getc_name(){
        return this.c_name;
    }

    public static void main(String[] args) {
        User a = new User(555, "HHJ", "09/06/2001", "LXH", "HLK");
    }
}
