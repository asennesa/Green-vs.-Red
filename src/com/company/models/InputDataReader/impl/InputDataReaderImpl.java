package com.company.models.InputDataReader.impl;

import com.company.models.InputDataReader.InputDataReader;
import com.company.validators.GridValidator;

import java.util.Scanner;

public class InputDataReaderImpl implements InputDataReader {

    private int x;
    private int y;
    private int x1;
    private int y1;
    private int N;
    private Scanner scanner;
    private String[][] grid;
    private GridValidator gridValidator;


    public InputDataReaderImpl(Scanner scanner, GridValidator gridValidator) {
        this.scanner = scanner;
        this.gridValidator = gridValidator;
    }

    public String[][] getGrid() {
        return grid;
    }

    private void setGrid(String[][] grid) {
        this.grid = grid;
    }

    @Override
    public int getX1() {
        return x1;
    }


    @Override
    public int getY1() {
        return y1;
    }


    @Override
    public int getN() {
        return N;
    }


    @Override
    public void read() {

       //Read and validate first Line(grid size)
        String firstInputLine = scanner.nextLine();
        if (!firstInputLine.matches("^\\d+, \\d+$")) {
            throw new IllegalArgumentException(
                    "Please enter grid size in format \"x, y\".\r\n" +
                            "Grid size cannot be null or empty, only positive numbers allowed!\r\n" +
                            "If you are copying the input as whole make sure you are not including white spaces before the actual input.");
        } else {
            String[] rowsCols = firstInputLine.split(", ");
            int x = Integer.parseInt(rowsCols[0]);
            int y = Integer.parseInt(rowsCols[1]);
            if (x > y || y > 1000) {
                throw new IllegalArgumentException("Invalid grid size, make sure x <= y < 1000.");
            } else {
                this.x = x;
                this.y = y;
            }
        }

        //Read and validate "y" number of lines
        String[][] zeroGenGrid = new String[this.y][this.x];
        for (int row = 0; row < y; row++) {
            String yLine = scanner.nextLine();
            if (yLine.length() > x || !yLine.matches("^[0,1]+$")) {
                throw new IllegalArgumentException(
                        "Grid row input lines should contain 0s and 1s only.\r\n" +
                                "Their length must be equal to \"x\"\r\n" +
                                "and their quantity must be equal to \"y\".");
            } else {
                String[] gridRow = yLine.split("");
                zeroGenGrid[row] = gridRow;
            }
        }
        this.setGrid(zeroGenGrid);

        //Read and validate last line(x1, y1, N)
        String lastInputLine = scanner.nextLine();
        if (!lastInputLine.matches("^\\d+, \\d+, \\d+$")) {
            throw new IllegalArgumentException("Make sure you have not entered more then \"y\" grid row lines\r\n" +
                    "and coordinates in format \"x1, y1, N\"(last input line) contain only positive numbers.");
        } else {
            String[] coordinates = lastInputLine.split(", ");
            int x1 = Integer.parseInt(coordinates[0]);
            int y1 = Integer.parseInt(coordinates[1]);
            if (!gridValidator.isIndexInBounds(zeroGenGrid, y1, x1)) {
                throw new IllegalArgumentException("Coordinates x1, y1 must point to an index inside of the grid.");
            } else {
                this.x1 = x1;
                this.y1 = y1;
                this.N = Integer.parseInt(coordinates[2]);

            }


        }

    }


}
