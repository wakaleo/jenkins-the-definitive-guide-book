package com.ciwithhudson.gameoflife.domain;

/**
 * A single cell, which can be alive or dead.
 */
abstract public class Cell {
    
    public abstract Boolean isAlive();
    
    public Boolean isDead() {
        return !isAlive();
    }
    
    public abstract Cell nextGeneration(int neighbourCount);

    public static Cell fromChar(char cellValue) {
        if (cellValue == LivingCell.SYMBOL) {
            return new LivingCell();
        } else if (cellValue == DeadCell.SYMBOL) {
            return new DeadCell();
        } 
        throw new IllegalArgumentException("Illegal cell value character: " + cellValue);
    }

}
