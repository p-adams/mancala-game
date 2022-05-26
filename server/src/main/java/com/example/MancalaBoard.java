package com.example;

import java.util.ArrayList;

public class MancalaBoard {
    private ArrayList<Integer> p1Store;
    private ArrayList<Integer> p2Store;
    private ArrayList<Integer> pits;

    public MancalaBoard() {
        this.p1Store = new ArrayList<Integer>();
        this.p2Store = new ArrayList<Integer>();
        this.pits = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getP1Store() {
        return p1Store;
    }

    public ArrayList<Integer> getP2Store() {
        return p2Store;
    }

    public ArrayList<Integer> getPits() {
        return pits;
    }
}