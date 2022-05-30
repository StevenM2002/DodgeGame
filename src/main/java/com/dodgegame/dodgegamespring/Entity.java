package com.dodgegame.dodgegamespring;

public class Entity {
    private int xLoc;
    private int yLoc;
    public Entity(int xSpawn, int ySpawn) {
        this.xLoc = xSpawn;
        this.yLoc = ySpawn;
    }

    public boolean isInBoard(Board board) {
        return xLoc < board.getXBoardLen() && xLoc >= 0 && yLoc < board.getYBoardLen() && yLoc >= 0;
    }
    public void moveDown() {
        yLoc--;

    }
    public void moveUp() {
        yLoc++;

    }
    public void moveLeft() {
        xLoc--;

    }
    public void moveRight() {
        xLoc++;
    }
    public int getYLoc() {
        return yLoc;
    }
    public int getXLoc() {
        return xLoc;
    }
}

