package org.dodgegame;

public class Board {
    public static int EMPTYSPACE = 0;
    public static int PLAYER = 1;
    public static int ENEMY = 2;
    public static int POINTOBJECTIVE = 3;
    public static int COLLISION = 4;
    private int xBoardLen;
    private int yBoardLen;
    private int numPoints = 0;
    private int[][] theBoard;
    public Board(int xBoardLen, int yBoardLen) {
        assert xBoardLen > 0;
        assert yBoardLen > 0;
        this.xBoardLen = xBoardLen;
        this.yBoardLen = yBoardLen;
        this.theBoard = new int[xBoardLen][yBoardLen];
        for (int row = 0; row < xBoardLen; row++) {
            for (int col = 0; col < yBoardLen; col++) {
                this.theBoard[row][col] = 0;
            }
        }
    }
    public int getXBoardLen() {
        return this.xBoardLen;
    }

    public int getYBoardLen() {
        return this.yBoardLen;
    }

    public void setEntityOnBoard(int xLoc, int yLoc, int spaceType) {
        assert xLoc < this.xBoardLen && xLoc >= 0;
        assert yLoc < this.yBoardLen && yLoc >= 0;
        this.theBoard[xLoc][yLoc] = spaceType;
    }

    public int getEntityOnBoard(int xLoc, int yLoc) {
        return this.theBoard[xLoc][yLoc];
    }

    public void printBoard() {
        for (int row = 0; row < this.xBoardLen; row++) {
            for (int col = 0; col < this.yBoardLen; col++) {
                System.out.print(this.theBoard[row][col]);
            }
            System.out.println();
        }
    }

}
