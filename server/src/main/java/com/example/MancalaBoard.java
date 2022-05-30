package com.example;

import java.util.ArrayList;

public class MancalaBoard {
    private ArrayList<Integer> p1Store;
    private ArrayList<Integer> p2Store;

    private ArrayList<Pit> p1pits;
    private ArrayList<Pit> p2pits;
    private ArrayList<ArrayList<Pit>> pits;

    public MancalaBoard() {
        this.p1Store = new ArrayList<Integer>();
        this.p2Store = new ArrayList<Integer>();
    }

    public void setBoard() {
        this.p1pits = new ArrayList<Pit>();
        this.p2pits = new ArrayList<Pit>();

        for (int i = 0; i <= 6; ++i) {
            this.p1pits.add(new Pit(Integer.toString(i)));
        }
        for (int i = 0; i <= 6; ++i) {
            this.p2pits.add(new Pit(Integer.toString(i)));
        }

        this.pits.add(this.p1pits);
        this.pits.add(this.p2pits);
    }

    public ArrayList<Integer> getP1Store() {
        return p1Store;
    }

    public ArrayList<Integer> getP2Store() {
        return p2Store;
    }

    public ArrayList<ArrayList<Pit>> getPits() {
        return pits;
    }
}