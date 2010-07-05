package com.ciwithhudson.gameoflife.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GridTest {

    Grid grid;
    @Before
    public void initGrid() {
        grid = new Grid(3,3);
    }
    
    @Test
    public void shouldCountZeroWhenAllNeighboursAreDead() {
        assertThat(grid.countNeighborsAt(1,1), is(0));
    }

    @Test
    public void shouldCountZeroInCornersWhenAllNeighboursAreDead() {
        assertThat(grid.countNeighborsAt(0,0), is(0));
        assertThat(grid.countNeighborsAt(0,2), is(0));
        assertThat(grid.countNeighborsAt(2,0), is(0));
        assertThat(grid.countNeighborsAt(2,2), is(0));
    }
    
}
