package com.company.validators.impl;

import com.company.validators.GridValidator;

import java.util.List;

public class GridValidatorImpl implements GridValidator {
    @Override
    public boolean isIndexInBounds(String[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }

    @Override
    public boolean hasNeighbours(List<Integer> possibleNeighbours, int countOfNeighbours) {
        return possibleNeighbours.contains(countOfNeighbours);
    }
}
