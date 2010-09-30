package com.ciwithhudson.gameoflife.domain;

public class LivingCell extends Cell {

    public static final char SYMBOL = '+';
    
    @Override
    public Boolean isAlive() {
        return true;
    }

    @Override
    public Cell nextGeneration(int neighbourCount) {
        if (neighbourCount >= 0 && neighbourCount <= 3) {
            return new LivingCell();
        } else {
            return new DeadCell();
        }
    }

    @Override
    public String toString() {
        return Character.toString(SYMBOL);
    }
    
}
