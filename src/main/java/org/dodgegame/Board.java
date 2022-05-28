package org.dodgegame;

import java.util.ArrayList;

public class Board {
    public static int EMPTYSPACE = 0;
    public static int PLAYER = 1;
    public static int ENEMY = 2;
    public static int POINTOBJECTIVE = 3;
    public static int COLLISION = 4;
    public static int OUTSIDEOFBOARD = -1;
    private int colLen;
    private int rowLen;
    private int numPoints = 0;
    private int[][] theBoard;
    public Board(int rowLen, int colLen) {
        assert colLen > 0;
        assert rowLen > 0;
        this.colLen = colLen;
        this.rowLen = rowLen;
        this.theBoard = new int[rowLen][colLen];
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                this.theBoard[row][col] = 0;
            }
        }
    }
    public int getXBoardLen() {
        return this.colLen;
    }

    public int getYBoardLen() {
        return this.rowLen;
    }

    public void setEntityOnBoard(int col, int row, int spaceType) {
        if (!isInBoard(col, row)) throw new ArrayIndexOutOfBoundsException();
        this.theBoard[row][col] = spaceType;
    }

    public int getEntityOnBoard(int col, int row) {
        if (!isInBoard(col, row)) return OUTSIDEOFBOARD;
        return this.theBoard[row][col];
    }

    public void printBoard() {
        for (int row = 0; row < this.rowLen; row++) {
            for (int col = 0; col < this.colLen; col++) {
                System.out.print(this.theBoard[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] getTheBoard() {
        return theBoard;
    }
    private void placeEntitiesOnBoard(ArrayList<ArrayList<Enemy>> allEnemyWave,
                                      ArrayList<ArrayList<PointsObjective>> allPointsObjectives,
                                      Player player) {
        // waveLength is same for allPointsObjectives and allEnemyWave
        int waveLength = allEnemyWave.size();
        for (int i = 0; i < waveLength; i++) {
            for (Enemy enemy : allEnemyWave.get(i)) {
                this.setEntityOnBoard(enemy.getXLoc(), enemy.getYLoc(), Board.ENEMY);
            }
            for (PointsObjective point : allPointsObjectives.get(i)) {
                this.setEntityOnBoard(point.getXLoc(), point.getYLoc(), Board.POINTOBJECTIVE);
            }
        }
    }

    public int numVertices() {
        return colLen * rowLen;
    }

    public boolean isAdjacent(Coord a, Coord b) {
        // If left or right
        if (a.y() == b.y()) {
            if (a.x() == b.x() + 1) return true;
            if (a.x() == b.x() - 1) return true;
        }
        // If up or down
        if (a.x() == b.x()) {
            if (a.y() == b.y() + 1) return true;
            if (a.y() == b.y() - 1) return true;
        }
        return false;
    }

    public boolean isInBoard(int x, int y) {
        return x >= 0 && x < getXBoardLen() && y >= 0 && y < getYBoardLen();
    }

}
