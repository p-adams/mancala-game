package com.example;

import java.util.ArrayList;

public class MancalaBoard {
    private ArrayList<Integer> p1Store;
    private ArrayList<Integer> p2Store;
    private ArrayList<Pit> pits;

    public MancalaBoard() {
        this.p1Store = new ArrayList<Integer>();
        this.p2Store = new ArrayList<Integer>();
        this.pits = new ArrayList<Pit>();
        for (int i = 0; i <= 12; ++i) {
            this.pits.add(new Pit());
        }
    }

    public ArrayList<Integer> getP1Store() {
        return p1Store;
    }

    public ArrayList<Integer> getP2Store() {
        return p2Store;
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }
}