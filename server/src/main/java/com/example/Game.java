package com.example;

public class Game {
    private Player p1;
    private Player p2;

    public Game(GameConfig config) {
        // TODO: initialize players with config values
        p1 = new Player(config.getP1Name());
        p2 = new Player(config.getP2Name());
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

}
