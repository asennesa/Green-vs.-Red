package com.company.core.impl;

import com.company.common.Constants;
import com.company.core.GameCore;
import com.company.models.grid.Grid;
import com.company.models.InputDataReader.InputDataReader;
import com.company.validators.GridValidator;

public class GameCoreImpl extends Constants implements GameCore {
    private InputDataReader inputDataReader;
    private Grid grid;
    private GridValidator gridValidator;
    private int timesGreenCounter;
    private int countOfGreenNeighbours;

    public GameCoreImpl(InputDataReader inputDataReader, Grid grid, GridValidator gridValidator) {
        this.inputDataReader = inputDataReader;
        this.gridValidator = gridValidator;
        this.grid = grid;

    }

    public int getTimesGreenCounter() {
        return timesGreenCounter;
    }

    @Override
    public void play() {
        for (int generation = 0; generation <= inputDataReader.getN(); generation++) {
            grid.evolve();
            //Increasing count of generations where x1,y1 was green
            if (grid.getGridCurrentGen()[inputDataReader.getY1()][inputDataReader.getX1()].equals(GREEN)) {
                timesGreenCounter++;
            }
            //Going trough indexes by row/col loops.
            for (int row = 0; row < grid.getGridCurrentGen().length; row++) {
                for (int col = 0; col < grid.getGridCurrentGen()[row].length; col++) {
                    //Finding index count of green neighbours
                    for (int j = 0; j < neighbourPositions.length; j += 2) {
                        int neighbourCordX = row + Integer.parseInt(neighbourPositions[j]);
                        int neighbourCordY = col + Integer.parseInt(neighbourPositions[j + 1]);
                        if (gridValidator.isIndexInBounds(grid.getGridCurrentGen(), neighbourCordX, neighbourCordY) && grid.getGridCurrentGen()[neighbourCordX][neighbourCordY].equals(GREEN)) {
                            countOfGreenNeighbours++;
                        }
                    }
                    //Applying each rule and adding the result to the next gen grid.
                    //Rule 1
                    if (grid.getGridCurrentGen()[row][col].equals(RED) && gridValidator.hasNeighbours(RULE_ONE_POSSIBLE_GREEN_NEIGHBOURS, countOfGreenNeighbours)) {
                        grid.getGridNextGen()[row][col] = GREEN;
                        //Rule 2
                    } else if (grid.getGridCurrentGen()[row][col].equals(RED) && gridValidator.hasNeighbours(RULE_TWO_POSSIBLE_GREEN_NEIGHBOURS, countOfGreenNeighbours)) {
                        grid.getGridNextGen()[row][col] = RED;
                        //Rule 3
                    } else if (grid.getGridCurrentGen()[row][col].equals(GREEN) && gridValidator.hasNeighbours(RULE_THREE_POSSIBLE_GREEN_NEIGHBOURS, countOfGreenNeighbours)) {
                        grid.getGridNextGen()[row][col] = RED;
                        //Rule 4
                    } else if (grid.getGridCurrentGen()[row][col].equals(GREEN) && gridValidator.hasNeighbours(RULE_FOUR_POSSIBLE_GREEN_NEIGHBOURS, countOfGreenNeighbours)) {
                        grid.getGridNextGen()[row][col] = GREEN;
                    }
                    countOfGreenNeighbours = 0;

                }
            }
        }

    }

    @Override
    public String gameResult() {
        return String.format("Result: %d", this.getTimesGreenCounter());
    }


}
