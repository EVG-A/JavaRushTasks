package com.javarush.games.snake;
import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH;
    public static final int HEIGHT;
    static{
        WIDTH = 15;
        HEIGHT = 15;
    }
    public void initialize(){
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }
    private void createGame(){
        drawScene();
        //Apple apple = new Apple(7,7);
        //apple.draw(this);
    }
    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.BLUE);
            }
        }
    }
}