package com.company.common;

import java.util.Arrays;
import java.util.List;

public class Constants {
    //All constant data taken away separately with names for better readability.
    protected final String RED = "0";
    protected final String GREEN = "1";
    protected final List<Integer> RULE_ONE_POSSIBLE_GREEN_NEIGHBOURS = Arrays.asList(3, 6);
    protected final List<Integer> RULE_TWO_POSSIBLE_GREEN_NEIGHBOURS = Arrays.asList(0, 1, 2, 4, 5, 7, 8);
    protected final List<Integer> RULE_THREE_POSSIBLE_GREEN_NEIGHBOURS = Arrays.asList(0, 1, 4, 5, 7, 8);
    protected final List<Integer> RULE_FOUR_POSSIBLE_GREEN_NEIGHBOURS = Arrays.asList(2, 3, 6);
    protected final String[] neighbourPositions = new String[]{
            "-1", "-1", "-1", "0", "-1", "+1", "0", "-1",
            "0", "+1", "+1", "-1", "+1", "0", "+1", "+1",
    };
}
