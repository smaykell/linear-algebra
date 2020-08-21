package main.java.algebra;

public class Main {

    public static void main(String[] args) {

        double[][] a = { { -1, 2, -4 }, { 3, 4, 6 }, { 2, 1, 0 } };
        double[][] b = { { 0, 2, -4 }, { 8, 1, 3 }, { 3, 1, 1 } };

        Matrix A = new Matrix("A", a);
        Matrix B = new Matrix("B", b);

        Matrix C = A.mul(B);

        C.print();

    }
}
