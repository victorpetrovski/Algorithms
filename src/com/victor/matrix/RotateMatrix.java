package com.victor.matrix;

/**
 * Created by Victor on 12/4/17.
 */

/**
 * ( Cracking the Coding interview 4th edition )
 * 1.6
 * Task:
 *  Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write
 *  a method to rotate the image by 90 degrees. Can you do this in place rotation?
 *
 * Solution:
 *
 *  =-
 *
 * */

public class RotateMatrix {

    public static int[][] createMatrix(int N) {

        int[][] matrix = new int[N][N];
        int counter = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = ++counter;
            }
        }
        return matrix;
    }


    public void swap(int[][] matrix, int i, int j, int newi, int newj) {
        System.out.println("Swapping: (" + i + "," + j + ")\t" + "(" + newi + "," + newj + ")");
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[newi][newj];
        matrix[newi][newj] = tmp;
    }

    public void rotateMatrix90degree(int[][] matrix) {

        int level = 0;
        int N = matrix.length;
        int lastIndex = N - 1;

        while (level < N / 2) {
            for (int i = level; i < N - 1 - level; i++) {
                swap(matrix, i, level, level, lastIndex - i);
                swap(matrix, i, level, lastIndex - i, lastIndex - level);
                swap(matrix, i, level, lastIndex - level, i);
                System.out.println("");
            }
            level++;
        }

        printMatrix(matrix);
    }

    /**
     * Print the matrix formatted
     * */

    public static void printMatrix(int[][] matrix) {
        int rowsLength = matrix.length;
        for (int k = 0; k < rowsLength; k++) {
            printMatrix(k, matrix);
        }
    }

    private static void printMatrix(int row, int[][] matrix) {
        int size = matrix.length;

        for (int i = 0; i < 7 * size; i++) {
            System.out.print("-");
        }
        System.out.println("-");

        for (int i = 1; i <= matrix[row].length; i++) {
            System.out.printf("| %4d ", matrix[row][i - 1]);
        }
        System.out.println("|");


        if (row == size - 1) {
            // when we reach the last row,
            // print bottom line "---------"
            for (int i = 0; i < 7 * size; i++) {
                System.out.print("-");
            }
            System.out.println("-");

        }
    }
}
