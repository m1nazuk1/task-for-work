package org.example.task_2;

public class DiagonalMin {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {5, 7, 9, 2, 1},
                {0, 9, 1, 8, 7},
                {6, 3, 6, 6, 6},
                {99, 100, -2, 3, 1}
        };

        System.out.println("Минимальный элемент побочной диагонали: " + findMinSecondaryDiagonalElement(matrix));
    }

    public static int findMinSecondaryDiagonalElement(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int value = matrix[i][n - 1 - i];
            if (i != n - 1 - i && value < min) {
                min = value;
            }
        }

        return min;
    }
}
