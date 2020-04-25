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
        double [][] actual_res = mtr.multiply(first, second);
        assertArrayEquals(res, actual_res);
    }

    @Test
    public void TestAddition() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}};
        double [][] res = {{2, 4}, {6, 8}};
        double [][] actual_res = mtr.addition(first, second);
        assertArrayEquals(res, actual_res);
    }

    @Test()
    public void TestAdditionWithException() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}, {5, 6}};
        assertThrows(Exception.class, () -> mtr.addition(first, second));
    }

    @Test()
    public void TestAdditionWithException2() throws Exception {
        double [][] first = {{1, 2, 3}, {3, 4, 5}};
        double [][] second = {{1, 2}, {3, 4},};
        assertThrows(Exception.class, () -> mtr.addition(first, second));
    }

    @Test
    public void TestSubstraction() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}};
        double [][] res = {{0, 0}, {0, 0}};
        double [][] actual_res = mtr.substraction(first, second);
        assertArrayEquals(res, actual_res);
    }

    @Test()
    public void TestSubstractionWithException() throws Exception {
        double [][] first = {{1, 2}, {3, 4}};
        double [][] second = {{1, 2}, {3, 4}, {5, 6}};
        assertThrows(Exception.class, () -> mtr.substraction(first, second));
    }

    @Test()
    public void TestSubstractionWithException2() throws Exception {
        double [][] first = {{1, 2, 3}, {3, 4, 5}};
        double [][] second = {{1, 2}, {3, 4},};
        assertThrows(Exception.class, () -> mtr.substraction(first, second));
    }

    @Test
    public void TestAddValue0() {
        double [][] first = {{1, 2}, {3, 4}};
        int val = 0;
        Matrix a = new Matrix();
        double [][] actual_res = a.addValue(first, val);
        assertArrayEquals(first, actual_res);
    }

    @Test
    public void TestAddValue() {
        double [][] first = {{1, 2}, {3, 4}};
        int val = 10;
        double [][] res = {{11, 12}, {13, 14}};
        Matrix a = new Matrix();
        double [][] actual_res = a.addValue(first, val);
        assertArrayEquals(res, actual_res);
    }

    @Test
    public void TestReadMatrixFromFile() throws Exception {
        double[][] expect_matrix = {{1,2,3},{4,5,6},{7,8,9}};
        assertArrayEquals(expect_matrix, mtr.readMatrixFromFile("matrix1"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"matrix1", "matrix2", "matrix3"})
    public void TestReadMatrixFromFileWithNoThrow(String candidate) throws Exception {
        assertDoesNotThrow(() -> Matrix.readMatrixFromFile(candidate));
    }

}
