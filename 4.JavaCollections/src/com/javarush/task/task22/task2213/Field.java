package com.javarush.task.task22.task2213;

public class Field {
    private int width;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    private int height;
    private int[][] matrix;
    public void print(){

    }
    public void removeFullLines(){

    }
    public Integer getValue(int x, int y){
        return matrix[x][y];
    }
    public void setValue(int x, int y, int value){
        matrix[x][y] = value;
    }
}