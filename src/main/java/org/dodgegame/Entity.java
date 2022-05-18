package org.dodgegame;

public class Entity {
    private int xLoc;
    private int yLoc;
    public Entity(int xSpawn, int ySpawn) {
        this.xLoc = xSpawn;
        this.yLoc = ySpawn;
    }
    public void afterMovement() {

    }
    public void beforeMovement() {}
    public boolean isInBoard(Board board) {
        return xLoc < board.getXBoardLen() && xLoc >= 0 && yLoc < board.getYBoardLen() && yLoc >= 0;
    }
    public void moveDown() {
        beforeMovement();
        yLoc--;
        afterMovement();
    }
    public void moveUp() {
        beforeMovement();
        yLoc++;
        afterMovement();
    }
    public void moveLeft() {
        beforeMovement();
        xLoc--;
        afterMovement();
    }
    public void moveRight() {
        beforeMovement();
        xLoc++;
        afterMovement();
    }
    public int getYLoc() {
        return yLoc;
    }
    public int getXLoc() {
        return xLoc;
    }
}

