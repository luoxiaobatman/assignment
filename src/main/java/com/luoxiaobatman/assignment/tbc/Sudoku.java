package com.luoxiaobatman.assignment.tbc;

import java.util.*;

import static java.util.Arrays.asList;

public class Sudoku {

    private static final List<Integer> ALL_DIGITS = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private String input;

    private StringBuilder result = new StringBuilder();
    private String solution = "";

    private int array[][] = new int[9][9];

    public void findSimpleSolution() {
        initCellsFromInput();

        int r = mainCycle();
        if (r == 0)
            result.append("We did it ! Congratulations !\n" + "Simple!");
        if (r == -2)
            result.append("Too complex sudoku");
    }

    private void initCellsFromInput() {
        String[] rows = input.split("\\n");
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                char c = rows[i].toCharArray()[j];
                if (c == ' ') {
                    array[i][j] = 0;
                } else if (Character.getNumericValue(c) <= 9 && Character.getNumericValue(c) >= 0) {
                    array[i][j] = Character.getNumericValue(c);
                } else
                    throw new RuntimeException("Wrong input format");

            }

    }

    /**
     * Verify variants of the cell
     * if single variant is left -- it is a solution,  return it
     * if more then 1 variant -  return 0 (no solution yet)
     * if no variants -- error, return "-1"
     */
    private int checkMe(int str, int col) {
        List<Integer> variants = new ArrayList<>(ALL_DIGITS);
        Set<Integer> variantsToExclude = new HashSet<>();
        variantsToExclude.addAll(getSolvedByRow(col));
        variantsToExclude.addAll(getSolvedByColumn(str));
        variantsToExclude.addAll(getSolvedBySector(str, col));
        variants.removeAll(variantsToExclude);
        if (variants.size() > 1)
            return 0;
        if (variants.isEmpty())
            return -1;
        return array[str][col] = variants.get(0);
    }

    private List<Integer> getSolvedBySector(int str, int col) {
        int mini, maxi, minj, maxj;
        List<Integer> variants = new ArrayList<>();

        if (str <= 2) {
            mini = 0;
            maxi = 2;
        } else if (str <= 5) {
            mini = 3;
            maxi = 5;
        } else {
            mini = 6;
            maxi = 8;
        }
        if (col <= 2) {
            minj = 0;
            maxj = 2;
        } else if (col <= 5) {
            minj = 3;
            maxj = 5;
        } else {
            minj = 6;
            maxj = 8;
        }

        for (int i = mini; i <= maxi; i++)
            for (int j = minj; j <= maxj; j++) {
                if (array[i][j] != 0)
                    variants.add(array[i][j]);
            }
        return variants;
    }

    private List<Integer> getSolvedByColumn(int str) {
        List<Integer> variants = new ArrayList<>();
        for (int j = 0; j < 9; j++)
            if (array[str][j] != 0)
                variants.add(array[str][j]);
        return variants;
    }

    private List<Integer> getSolvedByRow(int col) {
        List<Integer> variants = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            if (array[i][col] != 0)
                variants.add(array[i][col]);
        return variants;
    }

    private void show() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                s.append(array[i][j]);
            }
            s.append("\n");
        }
        solution = s.toString();
    }

    /**
     * Return 0 - solved
     * ret -1 -- error
     * ret -2 -- cannot resolve
     */
    private int mainCycle() {
        for (; ; ) {
            if (isSolved()) {
                show();
                return 0;
            }

            boolean isNotPerformedAction = true;
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {

                    int retCode = 0;
                    boolean isCellActionPerformed = false;
                    if (array[i][j] == 0) {
                        retCode = checkMe(i, j);
                        if (retCode > 0) {  // cell was solved
                            isCellActionPerformed = true;
                        }
                    }
                    if (retCode == -1) {
                        result.append("ERROR: input is not a sudoku\n");
                        return -1;
                    }
                    if (isCellActionPerformed)
                        isNotPerformedAction = false;


                }

            if (isNotPerformedAction) {  // no action for whole table of cells
                return -2;
            }

        }
    }

    private boolean isSolved() {
        boolean isSolved = true;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (array[i][j] == 0)
                    isSolved = false;
            }
        return isSolved;
    }

    public String getResult() {
        return result.toString();
    }

    public String getSolution() {
        return solution;
    }

    public void setInput(String input) {
        this.input = input;
    }


}



