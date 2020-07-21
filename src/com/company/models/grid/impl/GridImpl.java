package com.company.models.grid.impl;

import com.company.models.grid.Grid;

import java.util.Arrays;

public class GridImpl implements Grid {
    //First and next generation grids,current evolves into next "N" times inside GameCoreImpl.
    private String[][] gridCurrentGen;
    private String[][] gridNextGen;

    public GridImpl(String[][] gridCurrentGen) {
        this.gridCurrentGen = gridCurrentGen;
        this.gridNextGen = initializeGridNextGen(gridCurrentGen);
    }

    @Override
    public String[][] getGridCurrentGen() {
        return gridCurrentGen;
    }


    @Override
    public String[][] getGridNextGen() {
        return gridNextGen;
    }


    @Override
    //Called at each start of a new generation inside GameGoreImpl.
    public void evolve() {
        this.gridCurrentGen = Arrays.stream(this.gridNextGen).map(String[]::clone).toArray(String[][]::new);

    }

    private String[][] initializeGridNextGen(String[][] gridCurrentGen) {
        return Arrays.stream(gridCurrentGen).map(String[]::clone).toArray(String[][]::new);
    }

}
