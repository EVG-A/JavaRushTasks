package com.javarush.games.snake;
import java.util.*;


public class Snake {
    private List<GameObject> snakeParts;
    
       
    
    public Snake(int x, int y){
        snakeParts = new ArrayList<>();
        GameObject go1 = new GameObject(x,y);
        GameObject go2 = new GameObject(x+1,y);
        GameObject go3 = new GameObject(x+2,y);
        snakeParts.add(go1);
        snakeParts.add(go2);
        snakeParts.add(go3);
    }
}