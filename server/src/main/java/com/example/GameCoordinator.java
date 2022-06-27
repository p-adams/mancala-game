package com.example;

public class GameCoordinator {
    private Player p1;
    private Player p2;
    private MancalaBoard board;

    public GameCoordinator() {
    }

    public void setGame(GameData gameData) {
        p1 = new Player(gameData.getP1Name());
        p2 = new Player(gameData.getP2Name());
        this.board = new MancalaBoard();
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public MancalaBoard getBoard() {
        return board;
    }

    public void pickupStones(String label) {
    }

    public void dropStone(String label) {
    }

}
