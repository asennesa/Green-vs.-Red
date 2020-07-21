package com.company.models.grid;

import java.util.Scanner;

public interface Grid {

    void evolve();

    String[][] getGridCurrentGen();

    String[][] getGridNextGen();


}
