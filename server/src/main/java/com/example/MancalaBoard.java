package com.example;

import java.util.ArrayList;

public class MancalaBoard {
    private ArrayList<Integer> p1Store;
    private ArrayList<Integer> p2Store;

    private ArrayList<Pit> _p1pits;
    private ArrayList<Pit> _p2pits;
    private ArrayList<ArrayList<Pit>> pits;

    public MancalaBoard() {
        this.p1Store = new ArrayList<Integer>();
        this.p2Store = new ArrayList<Integer>();
    }

    public void setBoard() {
        this._p1pits = new ArrayList<Pit>();
        this._p2pits = new ArrayList<Pit>();

        for (int i = 0; i <= 6; ++i) {
            this._p1pits.add(new Pit(Integer.toString(i)));
        }
        for (int i = 0; i <= 6; ++i) {
            this._p2pits.add(new Pit(Integer.toString(i)));
        }

        this.pits.add(this._p1pits);
        this.pits.add(this._p2pits);
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