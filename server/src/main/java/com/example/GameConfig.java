package com.example;

public class GameConfig {
    private String p1Name;
    private String p2Name;

    public GameConfig(String p1Name, String p2Name) {
        this.p1Name = p1Name;
        this.p2Name = p2Name;
    }

    public String getP1Name() {
        return p1Name;
    }

    public String getP2Name() {
        return p2Name;
    }

}
