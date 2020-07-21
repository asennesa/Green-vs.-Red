package com.company;

import com.company.core.GameCore;
import com.company.core.impl.GameCoreImpl;
import com.company.models.InputDataReader.InputDataReader;
import com.company.models.InputDataReader.impl.InputDataReaderImpl;
import com.company.models.grid.Grid;
import com.company.models.grid.impl.GridImpl;
import com.company.validators.GridValidator;
import com.company.validators.impl.GridValidatorImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            GridValidator gridValidator = new GridValidatorImpl();
            InputDataReader inputDataReader = new InputDataReaderImpl(scanner,gridValidator);
            inputDataReader.read();
            Grid grid = new GridImpl(inputDataReader.getGrid());
            GameCore gameCore = new GameCoreImpl(inputDataReader, grid, gridValidator);
            gameCore.play();
            System.out.println(gameCore.gameResult());

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());

        }



    }
}

