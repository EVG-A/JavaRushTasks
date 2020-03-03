package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 30;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private final static String MINE = "\uD83D\uDCA3";
    private final static String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.WHITE);
            }
        }
        countMineNeighbors();
        this.countFlags = countMinesOnField;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game over", Color.BLACK, 50);
        showAllMines();
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game WIN", Color.BLACK, 50);
    }

    private void showAllMines() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                GameObject currentObject = gameField[y][x];
                if (currentObject.isMine) {
                    setCellValue(x, y, MINE);
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                GameObject currentObject = gameField[y][x];
                setCellValue(x, y, "");
                if (!currentObject.isMine) {
                    int count = 0;
                    List<GameObject> neighbors = getNeighbors(currentObject);
                    for (GameObject o : neighbors) {
                        if (o.isMine) count++;
                    }
                    currentObject.countMineNeighbors = count;
                }
            }
        }
    }

    private void restart() {
        isGameStopped = false;
        score = 0;
        setScore(score);
        countMinesOnField = 0;
        countClosedTiles = SIDE * SIDE;
        createGame();
    }

    private void openTile(int x, int y) {
        if (!isGameStopped && !gameField[y][x].isFlag && !gameField[y][x].isOpen) {
            if (!gameField[y][x].isMine) {
                gameField[y][x].isOpen = true;
                countClosedTiles--;
                score += 5;
                setScore(score);
                if (countMinesOnField == countClosedTiles) win();

                setCellColor(x, y, Color.GREY);

                if (gameField[y][x].countMineNeighbors == 0) {
                    setCellValue(x, y, "");
                    for (GameObject obj : getNeighbors(gameField[y][x])) {
                        openTile(obj.x, obj.y);
                    }
                } else {
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                }
            } else {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            }
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped) return;
        GameObject o = gameField[y][x];
        if (!o.isOpen) {
            if (countFlags != 0 || o.isFlag) {
                if (o.isFlag) {
                    o.isFlag = false;
                    countFlags++;
                    setCellValue(x, y, "");
                    setCellColor(x, y, Color.WHITE);
                } else {
                    o.isFlag = true;
                    countFlags--;
                    setCellValue(x, y, FLAG);
                    setCellColor(x, y, Color.YELLOW);
                }
            }
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) restart();
        else openTile(x, y);
    }
}