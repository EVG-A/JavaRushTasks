package com.javarush.task.task22.task2213;

public class Figure {
    private int x;

    public int getX() {
        return x;
    }

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    private int y;
    private int[][] matrix;

}
