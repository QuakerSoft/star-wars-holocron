package com.devin.Model;

public class Planet{
    private String name;
    private String climate;
    private String terrain;
    private String population;

    public Planet(String name, String climate, String terrain, String population) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getPopulation() {
        return population;
    }
}
