package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {
    public static double [][] addition(double [][] first, double [][] second) throws Exception {
        if (first.length != second.length || first[0].length != second[0].length)
            throw new Exception();
        double[][] res = new double[first.length][second[0].length];
        for (int i = 0; i < first.length; i++)
            for (int j = 0; j < first[0].length; j++)
                res[i][j] = first[i][j] + second[i][j];
        return res;
    }
    public static double [][] substraction(double [][] first, double [][] second) throws Exception {
        if (first.length != second.length || first[0].length != second[0].length)
            throw new Exception();
        double[][] res = new double[first.length][second[0].length];
        for (int i = 0; i < first.length; i++)
            for (int j = 0; j < first[0].length; j++)
                res[i][j] = first[i][j] - second[i][j];
        return res;
    }
    public static double [][] addValue(double [][] first, double value) {
        if (value == 0)
            return first;
        double[][] res = new double[first.length][first[0].length];
        for (int i = 0; i < first.length; i++)
            for (int j = 0; j < first[0].length; j++)
                res[i][j] = first[i][j] + value;
        return res;
    }
    public static double[][] readMatrixFromFile(String file) throws Exception {
        FileReader fileReader = new FileReader("./src/main/java/resources/" + file);
        Scanner scanner = new Scanner(fileReader);

        List<Double> matrix = new ArrayList<>();

        int row = 0, col = 0;
        while(scanner.hasNextLine()) {
            col = 0;
            Scanner rowScanner = new Scanner(scanner.nextLine());
            while(rowScanner.hasNextDouble()) {
                matrix.add(rowScanner.nextDouble());
                col++;
            }
            row++;
        }
        double[][] result = new double[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                result[r][c] = matrix.get(r * col + c);
            }
        }
        fileReader.close();
        return result;
    }
    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }
    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static void print(double[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}
