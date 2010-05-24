package com.ciwithhudson.gameoflife.domain;

/**
 * A two-dimensional array of cells.
 */
public class Grid {

    private Cell[][] cells;
    
    public Grid(int rows, int columns) {
        initializeCells(rows, columns);        
    }

    public Cell getCellAt(int row, int column) {
        return cells[row][column];
    }
    
    public void setCellAt(int row, int column, Cell cell) {
        cells[row][column] = cell;
    }
    
    public Cell[][] getRows() {
        return cells;
    }

    private void initializeCells(int rows, int columns) {
        cells = new Cell[rows][columns];
        for(Cell[] row : cells) {
            for(int column = 0; column < row.length; column++) {
                row[column] = new DeadCell();
            }
        }
    }

    public int countNeighborsAt(int row, int column) {
        int neighboursInPreviousRow = countNeighboursInPreviousRow(row, column);
        int neighboursInThisRow = countNeighboursInCurrentRow(row, column);
        int neighboursInNextRow = countNeighboursInNextRow(row, column);
        return neighboursInPreviousRow + neighboursInThisRow + neighboursInNextRow;
    }

    private int countNeighboursInPreviousRow(int row, int column) {
        int neighbourTotal = countLiveCellsAt(row - 1, column - 1)
                             + countLiveCellsAt(row - 1, column)
                             + countLiveCellsAt(row - 1, column + 1);
        
        return neighbourTotal;
    }

    private int countNeighboursInCurrentRow(int row, int column) {
        int neighbourTotal = countLiveCellsAt(row, column - 1)
                             + countLiveCellsAt(row, column + 1);
        
        return neighbourTotal;
    }

    private int countNeighboursInNextRow(int row, int column) {
        int neighbourTotal = countLiveCellsAt(row + 1, column - 1)
                             + countLiveCellsAt(row + 1, column)
                             + countLiveCellsAt(row + 1, column + 1);
        
        return neighbourTotal;
    }

    private int countLiveCellsAt(int row, int column) {
        if ((row >= 0) && (row < cells.length)) {
            if ((column >= 0) && (column < cells[0].length)){
                Cell cell = cells[row][column];
                if (cell.isAlive()) {
                    return 1;
                }
            }
        }
        return 0;
    }
    
    

}
