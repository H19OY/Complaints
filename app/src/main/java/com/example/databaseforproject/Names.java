package com.example.databaseforproject;

public class Names {
    String idn;
    String name;
    String type;
    public Names()
    {



    }

    public Names(String idn, String name, String type) {
        this.idn = idn;
        this.name = name;
        this.type = type;
    }

    public String getIdn() {
        return idn;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
