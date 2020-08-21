package main.java.algebra;

import java.util.Scanner;

public class Matrix {

    private String id;
    private double[][] matrix;
    private Scanner scanner;

    public Matrix(String id, double[][] matrix) {
        this.id = id;
        this.matrix = matrix;
        this.scanner = new Scanner(System.in);
    }

    public Matrix(String id, int rows, int columns) {
        this.id = id;
        this.matrix = new double[rows][columns];
        this.scanner = new Scanner(System.in);
    }

    public String getId() {
        return this.id;
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

    public void read() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                System.out.print(String.format("%s[%s, %s] :", this.id, i, j));
                this.matrix[i][j] = this.scanner.nextDouble();
            }
        }
    }

    public void transpose() {
        double[][] transposed = new double[this.matrix[0].length][this.matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                transposed[j][i] = this.matrix[i][j];
            }
        }
        this.matrix = transposed;
    }

    public void print() {
        String row;
        System.out.println(String.format("\n%s=", this.id));
        for (int i = 0; i < this.matrix.length; i++) {
            row = "\t";
            for (int j = 0; j < this.matrix[0].length; j++) {
                row += this.matrix[i][j] + "\t";
            }
            System.out.println(row);
        }
    }

    public Matrix add(Matrix matriz) {
        if ((this.matrix.length != matriz.getMatrix().length)
                || (this.matrix[0].length != matriz.getMatrix()[0].length))
            System.err.println(String.format("It is not possible to carry out %s+%s", this.id, matriz.getId()));

        double[][] result = new double[this.matrix.length][this.matrix[0].length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result[i][j] = this.matrix[i][j] + matriz.getMatrix()[i][j];
            }
        }

        return new Matrix(String.format("%s+%s", this.id, matriz.getId()), result);
    }

    public Matrix sub(Matrix matriz) {
        if ((this.matrix.length != matriz.getMatrix().length)
                || (this.matrix[0].length != matriz.getMatrix()[0].length))
            System.err.println(String.format("It is not possible to carry out %s-%s", this.id, matriz.getId()));

        double[][] result = new double[this.matrix.length][this.matrix[0].length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result[i][j] = this.matrix[i][j] - matriz.getMatrix()[i][j];
            }
        }

        return new Matrix(String.format("%s-%s", this.id, matriz.getId()), result);
    }

    public Matrix mul(Matrix matrix) {
        if (this.matrix[0].length != matrix.getMatrix().length)
            System.err.println(String.format("It is not possible to carry out %s%s", this.id, matrix.getId()));

        double[][] product = new double[this.matrix[0].length][matrix.getMatrix().length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                for (int k = 0; k < this.matrix[0].length; k++) {
                    product[i][j] += this.matrix[i][k] * matrix.getMatrix()[k][j];
                }
            }
        }
        return new Matrix(String.format("%sx%s", this.id, matrix.getId()), product);
    }

    public Matrix mul(int n) {
        double[][] product = new double[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                product[i][j] = (double) n * this.matrix[i][j];
            }
        }
        return new Matrix(String.format("%s%s", n, this.id), product);
    }

}
