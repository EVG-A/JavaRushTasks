package com.javarush.task.task22.task2213;

public class Tetris {
    private Field field;
    public static Tetris game;

    public void run(){

    }

    public void step(){

    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    private Figure figure;
    public static void main(String[] args) {
        Tetris.game = new Tetris();
        game.run();
    }
}
