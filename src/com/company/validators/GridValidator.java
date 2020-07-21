package com.company.validators;

import java.util.List;

public interface GridValidator {
    boolean isIndexInBounds(String[][] grid, int row, int col);

    boolean hasNeighbours(List<Integer> possibleNeighbours, int countOfNeighbours);
}
