package com.devin.Model;

public class Character {
    private String name;
    private String birth_year;
    private String height;
    private String mass;

    public Character(String name, String birthYear, String height, String mass) {
        this.name = name;
        this.birth_year = birthYear;
        this.height = height;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getHeight() {
        return height;
    }
    public String getMass(){
        return mass;
    }
}
