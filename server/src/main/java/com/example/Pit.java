package com.example;

import java.util.ArrayList;

public class Pit {
    ArrayList<Integer> stones;
    String label;

    public Pit(String label) {
        this.label = label;
        this.stones = new ArrayList<Integer>();
        for (int i = 0; i < 4; ++i) {
            this.stones.add(1);
        }
    }

    public void addStone() {
        this.stones.add(1);
    }

    public ArrayList<Integer> getStones() {
        return this.stones;
    }

    public Integer getStonesCount() {
        return this.stones.size();
    }

    public String getLabel() {
        return this.label;
    }
}
