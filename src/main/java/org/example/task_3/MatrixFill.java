package org.example.task_3;

public class MatrixFill {
    public static void main(String[] args) {
        printMatrix(fillMatrix(4, 1));
        printMatrix(fillMatrix(6, 2));
        printMatrix(fillMatrix(8, 3));
    }

    public static int[][] fillMatrix(int size, int layers) {
        int[][] matrix = new int[size][size];
        int num = layers;

        for (int layer = 0; layer < layers; layer++) {
            for (int j = layer; j < size - layer; j++) {
                matrix[layer][j] = num;
                matrix[size - 1 - layer][j] = num;
            }

            for (int i = layer; i < size - layer; i++) {
                matrix[i][layer] = num;
                matrix[i][size - 1 - layer] = num;
            }

            num--;
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
