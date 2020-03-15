package com.epam.mentoring.module2.task1;

import java.util.Arrays;

public class Main {

    private static Integer[][] mas = {
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1},
    };

    private static Integer[][] mas2 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };

    private static void replaceOneToZeroInRectangle(Integer[][] mas, int x, int y) {
        for (int i = x; i < mas.length && mas[i][y] != 0; i++) {
            for (int j = y; j < mas[i].length && mas[i][j] != 0; j++) {
                mas[i][j] = 0;
            }
        }
    }

    private static int countRectangles(Integer[][] mas) {
        Integer[][] masCopy = deepCopy(mas);
        int count = 0;
        for (int i = 0; i < masCopy.length; i++) {
            for (int j = 0; j < masCopy[i].length; j++) {
                if (masCopy[i][j] == 1) {
                    replaceOneToZeroInRectangle(masCopy, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static Integer[][] deepCopy(Integer[][] mas) {
        Integer[][] masCopy = new Integer[mas.length][mas.length];
        for (int i = 0; i < mas.length; i++)
            masCopy[i] = Arrays.copyOf(mas[i], mas[i].length);

        return masCopy;
    }

    public static void main(String[] args) {
        System.out.println(countRectangles(mas2));
        for (Integer[] row : mas2) System.out.println(Arrays.toString(row));
    }
}
