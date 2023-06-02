package com.example.appjson;

import java.util.List;

public class Pokemon {
    private String name;
    private Sprites sprites;
    private List<Stats> stats;
    private String stat;

    public String getStat() {
        return stat;
    }
    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Sprites getSprites() {return sprites;}
    public void setSprites(Sprites sprites) {this.sprites = sprites; }




}




