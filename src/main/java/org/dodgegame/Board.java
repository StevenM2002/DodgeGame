package org.dodgegame;

public class Board {
    public static int EMPTYSPACE = 0;
    public static int PLAYER = 1;
    public static int ENEMY = 2;
    public static int POINTOBJECTIVE = 3;
    public static int COLLISION = 4;
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
        assert col < this.colLen && col >= 0;
        assert row < this.rowLen && row >= 0;
        this.theBoard[row][col] = spaceType;
    }

    public int getEntityOnBoard(int col, int row) {
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

}
