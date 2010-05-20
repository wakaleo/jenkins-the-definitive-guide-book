package com.ciwithhudson.gameoflife.domain;

/**
 * The universe is a two-dimensional array of cells that evolve through time.
 */
public class Universe {

    private Grid grid;
    private int rowCount;
    private int columnCount;
    
    public Universe(int rows, int columns) {
        this.rowCount = rows;
        this.columnCount = columns;
        grid = new Grid(rowCount, columnCount);
    }

    public void nextGeneration() {
        Grid newGrid = spawnNewGrid();
        grid = newGrid;
    }

    public Cell[][] getCells() {
        return grid.getRows();
    }
    
    private Grid spawnNewGrid() {
        Grid newGrid = new Grid(rowCount, columnCount);
        for(int row = 0 ; row < rowCount; row++) {
            for(int column = 0; column < columnCount; column++) {
                int neighbourCount = grid.countNeighborsAt(row, column);
                Cell currentCell = grid.getCellAt(row, column);
                Cell newCell = currentCell.nextGeneration(neighbourCount);
                newGrid.setCellAt(row, column, newCell);
            }
        }
        return newGrid;
    }

    @Override
    public String toString() {
        StringBuffer displayedGrid = new StringBuffer();
        for(Cell[] row : grid.getRows()) {
            for(Cell cell : row) {
                displayedGrid.append(cell);
            }
            displayedGrid.append("\n");
        }
        return displayedGrid.toString();
    }

    public void seedWith(String initialState) {
        grid = new Grid(rowCount, columnCount);
        String[] rows = splitInitialStateIntoRows(initialState);
        int rowIndex = 0;
        for(String row : rows) {
            initializeRowOfCellsFromText(rowIndex++, row);
        }
    }

    private void initializeRowOfCellsFromText(int rowIndex, String rowContents) {
        int columnIndex = 0;
        for(char cellValue : rowContents.toCharArray()) {
            grid.setCellAt(rowIndex, columnIndex, Cell.fromChar(cellValue));
            columnIndex++;
        }
    }

    private String[] splitInitialStateIntoRows(String initialState) {
        return initialState.split(":");
    }
}
