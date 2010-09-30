package com.ciwithhudson.gameoflife.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CellTest {
   
    @Test
    public void aLivingCellShouldPrintAsAPlus() {
        Cell cell = new LivingCell();
        assertThat(cell.toString(), is("+"));
    }
    
    @Test
    public void aDeadCellShouldPrintAsAPlus() {
        Cell cell = new DeadCell();
        assertThat(cell.toString(), is("-"));
    }
    
    @Test
    public void thePlusSymbolShouldProduceALivingCell() {
        assertThat(Cell.fromChar('+'), is(instanceOf(LivingCell.class)));
    }
 
    @Test
    public void theMinusSymbolShouldProduceADeadCell() {
        assertThat(Cell.fromChar('-'), is(instanceOf(DeadCell.class)));
    }

}
