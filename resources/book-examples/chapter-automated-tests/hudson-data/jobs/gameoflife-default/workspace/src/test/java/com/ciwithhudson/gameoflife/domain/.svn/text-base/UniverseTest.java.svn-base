package com.ciwithhudson.gameoflife.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UniverseTest {

    private static final int ROW_COUNT = 4;
    private static final int COLUMN_COUNT = 5;

    Universe universe;
    
    @Before
    public void inTheBeginning() {
        universe = new Universe(ROW_COUNT,COLUMN_COUNT);
    }
    
    @Test
    public void aUniverseIsATwoDimentionalGridOfCells() {
        Cell[][] cells = universe.getCells();
        assertThat(cells, is(notNullValue())); 
        
        assertThat(cells.length, is(ROW_COUNT));
        for(Cell[] row : cells) {
            assertThat(row.length, is(COLUMN_COUNT));
        }
    }

    @Test
    public void theUniverseIsInitiallyVoidOfLife() {        
        Cell[][] cells = universe.getCells();
        
        for(Cell[] row : cells) {
           for(Cell cell : row) {
               assertThat(cell, is(notNullValue()));
               assertThat(cell.isAlive(), is(false));
           }
        }
    }
    
    @Test
    public void aNewVersionOfTheUniverseEvolvesEachGeneration() {
        Cell[][] currentGeneration = universe.getCells();
        
        universe.nextGeneration();
        
        Cell[][] nextGeneration = universe.getCells();
        
        assertThat(nextGeneration, is(not(equalTo(currentGeneration))));
    }
        
    @Test
    public void toStringShouldPrintTheFullCellGrid() {
        Universe universe = new Universe(3,3);
        assertThat(universe.toString(), is("---\n---\n---\n"));
    }

    @Test
    public void anEmptyGridCanBeInitializedWithAFormattedGridString() {
        String initialState = "---:---:---";
        Universe universe = new Universe(3,3);
        universe.seedWith(initialState);
        assertThat(universe.toString(), is("---\n---\n---\n"));
    }

    @Test
    public void aPopulatedGridCanBeInitializedWithAFormattedGridString() {
        String initialState = "+-+:-+-:+-+";
        Universe universe = new Universe(3,3);
        universe.seedWith(initialState);
        assertThat(universe.toString(), is("+-+\n-+-\n+-+\n"));
    }

    @Test
    public void aLiveCellWithNoNeighboursWillDieInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("---:-+-:---");
        universe.nextGeneration();
        assertThat(universe.toString(), is("---\n---\n---\n"));
    }

    @Test
    public void aLiveCellWithOneNeighbourWillDieInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("---:++-:---");
        universe.nextGeneration();
        assertThat(universe.toString(), is("---\n---\n---\n"));
    }

    @Test
    public void aLiveCellWithTwoNeighboursWillLiveInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("++-:-+-:---");
        universe.nextGeneration();
        assertThat(universe.toString(), is("++-\n++-\n---\n"));
    }

    @Test
    public void aLiveCellWithThreeNeighboursWillLiveInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("++-:++-:---");
        universe.nextGeneration();
        assertThat(universe.toString(), is("++-\n++-\n---\n"));
    }

    @Test
    public void aLiveCellWithFourNeighboursAboveWillDieInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("++-:+++:---");
        universe.nextGeneration();
        assertThat(universe.toString(), is("+-+\n+-+\n-+-\n"));
    }

    @Test
    public void aLiveCellWithFourNeighboursBelowWillDieInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("---:+++:++-");
        universe.nextGeneration();
        assertThat(universe.toString(), is("-+-\n+-+\n+-+\n"));
    }


    @Test
    public void aLiveCellWithFiveNeighboursWillDieInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("++-:+++:-+-");
        universe.nextGeneration();
        assertThat(universe.toString(), is("+-+\n--+\n+++\n"));
    }
    
    @Test
    public void aLiveCellWithSixNeighboursWillDieInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("++-:+++:++-");
        universe.nextGeneration();
        assertThat(universe.toString(), is("+-+\n--+\n+-+\n"));
    }

    @Test
    public void aDeadCellWithThreeNeighboursWillLiveInTheNextGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("++-:+--:---");
        universe.nextGeneration();
        assertThat(universe.toString(), is("++-\n++-\n---\n"));
    }

    
    @Test
    public void aUniverseCanHaveManySuccessiveGeneration() {
        Universe universe = new Universe(3,3);
        universe.seedWith("++-:+--:+-+");
        universe.nextGeneration();
        assertThat(universe.toString(), is("++-\n+--\n-+-\n"));
        universe.nextGeneration();
        assertThat(universe.toString(), is("++-\n+--\n---\n"));
        universe.nextGeneration();
        assertThat(universe.toString(), is("++-\n++-\n---\n"));
        universe.nextGeneration();
        assertThat(universe.toString(), is("++-\n++-\n---\n"));
    }
    
}
