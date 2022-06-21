package com.example;

import java.util.ArrayList;

public class MancalaBoard {
    private Pit p1Store;
    private Pit p2Store;

    private ArrayList<Pit> p1pits;
    private ArrayList<Pit> p2pits;
    private ArrayList<ArrayList<Pit>> pits;
    private String p1PitLabels[] = { "A1", "A2", "A3", "A4", "A5", "A6" };
    private String p2PitLabels[] = { "B1", "B2", "B3", "B4", "B5", "B6" };

    public MancalaBoard() {

        this.setBoard();
    }

    private void setBoard() {

        this.p1Store = new Pit("P1");
        this.p2Store = new Pit("P2");
        this.pits = new ArrayList<ArrayList<Pit>>();
        this.p1pits = new ArrayList<Pit>();
        this.p2pits = new ArrayList<Pit>();

        for (String label : p1PitLabels) {
            Pit pit = new Pit(label);
            pit.setStones();
            this.p1pits.add(pit);
        }
        for (String label : p2PitLabels) {
            Pit pit = new Pit(label);
            pit.setStones();
            this.p2pits.add(pit);
        }

        this.pits.add(this.p1pits);
        this.pits.add(this.p2pits);
    }

    public Pit getP1Store() {
        return this.p1Store;
    }

    public Pit getP2Store() {
        return this.p2Store;
    }

    public ArrayList<ArrayList<Pit>> getPits() {
        return this.pits;
    }

    public int getGamePieceTotal() {
        int count = 0;
        for (ArrayList<Pit> row : this.pits) {
            for (Pit pit : row) {
                count += pit.getStonesCount();
            }

        }
        return count;
    }

    public void pickupStones() {

    }

    public void dropStone() {

    }
}