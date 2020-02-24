package com.epam.mentoring;

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

    private static void replaceOneToZeroInRectangle(int x, int y) {
        for (int i = x; i < mas.length && mas[i][y] != 0; i++) {
            for (int j = y; j < mas[i].length && mas[i][j] != 0; j++) {
                mas[i][j] = 0;
            }
        }
    }

    private static int countRectangles() {
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == 1) {
                    replaceOneToZeroInRectangle(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countRectangles());
    }
}
