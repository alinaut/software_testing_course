package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class MatrixTest {

    private Matrix mtr;

    @BeforeEach
    public void initMatrix() {
        mtr = new Matrix();
    }

    @AfterEach
    public void deleteMatrix() {
        mtr = null;
    }

    @Test
    public void TestMultiply() {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}};
        double [][] res = {{7, 10}, {15, 22}};
        Matrix a = new Matrix();
        double [][] actual_res = a.multiply(first, second);
        Assert.assertArrayEquals(res, actual_res);
    }

    @Test
    public void TestAddition() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}};
        double [][] res = {{2, 4}, {6, 8}};
        Matrix a = new Matrix();
        double [][] actual_res = a.addition(first, second);
        Assert.assertArrayEquals(res, actual_res);
    }

    @Test(expected = Exception.class)
    public void TestAdditionWithException() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}, {5, 6}};
        double [][] res = {{2, 4}, {6, 8}};
        Matrix a = new Matrix();
        double [][] actual_res = a.addition(first, second);
    }

    @Test(expected = Exception.class)
    public void TestAdditionWithException2() throws Exception {
        double [][] first = {{1, 2, 3}, {3, 4, 5}};
        double [][] second = {{1, 2}, {3, 4},};
        double [][] res = {{2, 4}, {6, 8}};
        Matrix a = new Matrix();
        double [][] actual_res = a.addition(first, second);
    }

    @Test
    public void TestSubstraction() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}};
        double [][] res = {{0, 0}, {0, 0}};
        Matrix a = new Matrix();
        double [][] actual_res = a.substraction(first, second);
        Assert.assertArrayEquals(res, actual_res);
    }

    @Test(expected = Exception.class)
    public void TestSubstractionWithException() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}, {5, 6}};
        double [][] res = {{2, 4}, {6, 8}};
        Matrix a = new Matrix();
        double [][] actual_res = a.substraction(first, second);
    }

    @Test(expected = Exception.class)
    public void TestSubstractionWithException2() throws Exception {
        double [][] first = {{1, 2, 3}, {3, 4, 5}};
        double [][] second = {{1, 2}, {3, 4},};
        double [][] res = {{2, 4}, {6, 8}};
        Matrix a = new Matrix();
        double [][] actual_res = a.substraction(first, second);
    }

    @Test
    public void TestAddValue0() {
        double [][] first = {{1, 2}, {3, 4}};
        int val = 0;
        Matrix a = new Matrix();
        double [][] actual_res = a.addValue(first, val);
        Assert.assertArrayEquals(first, actual_res);
    }

    @Test
    public void TestAddValue() {
        double [][] first = {{1, 2}, {3, 4}};
        int val = 10;
        double [][] res = {{11, 12}, {13, 14}};
        Matrix a = new Matrix();
        double [][] actual_res = a.addValue(first, val);
        Assert.assertArrayEquals(res, actual_res);
    }

    @Test
    public void TestReadMatrixFromFile() throws Exception {
        double[][] expect_matrix = {{1,2,3},{4,5,6},{7,8,9}};
        assertArrayEquals(expect_matrix, mtr.readMatrixFromFile("matrix1"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"matrix1", "matrix2", "matrix3"})
    @Test
    public void TestReadMatrixFromFileWithNoThrow(String candidate) throws Exception {
        assertDoesNotThrow(() -> mtr.readMatrixFromFile(candidate));
    }

}
