package com.dodgegame.dodgegamespring;

import java.util.ArrayList;

public class Player extends Entity {
    Board board;
    int points = 0;
    int pointsGain = 100;
    public Player(int xSpawn, int ySpawn, Board board) {
        super(xSpawn, ySpawn);
        assert isInBoard(board);
        this.board = board;
        board.setEntityOnBoard(xSpawn, ySpawn, Board.PLAYER);
    }

    @Override
    public void moveLeft() {
        board.setEntityOnBoard(getXLoc(), getYLoc(), Board.EMPTYSPACE);
        super.moveLeft();
        if (!isInBoard(board)) {
            super.moveRight();
        }
        board.setEntityOnBoard(getXLoc(), getYLoc(), Board.PLAYER);
    }

    @Override
    public void moveRight() {

        board.setEntityOnBoard(getXLoc(), getYLoc(), Board.EMPTYSPACE);
        super.moveRight();
        if (!isInBoard(board)) {
            super.moveLeft();
        }
        board.setEntityOnBoard(getXLoc(), getYLoc(), Board.PLAYER);
    }
    // Use this method after movement on player
    public void ifAnyWaveCollision(ArrayList<Enemy> enemyWave, ArrayList<PointsObjective> pointsWave) {
        for (Enemy enemy : enemyWave) {
            ifEnemyCollision(enemy);
        }
        ArrayList<Integer> buf = new ArrayList<>();
        for (int i = 0; i < pointsWave.size(); i++) {
            if (isIfPointsCollision(pointsWave.get(i))) {
                buf.add(i);
            }
        }
        for (int i : buf) {
            pointsWave.remove(i);
        }
    }
    public void ifEnemyCollision(Enemy enemy) {
        if (enemy.getXLoc() == this.getXLoc() && enemy.getYLoc() == this.getYLoc()) {
            System.out.println("You have lost");
            board.setEntityOnBoard(this.getXLoc(), this.getYLoc(), Board.COLLISION);
            board.printBoard();
            System.exit(0);
        }
    }

    public boolean isIfPointsCollision(PointsObjective point) {
        if (point.getXLoc() == getXLoc() && point.getYLoc() == getYLoc()) {
            points += pointsGain;
            board.setEntityOnBoard(getXLoc(), getYLoc(), Board.PLAYER);
            return true;
        }
        return false;
    }
    public int getPoints() {return points;}

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException();
    }
}
