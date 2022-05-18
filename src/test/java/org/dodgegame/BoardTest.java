package org.dodgegame;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    void getXBoardLen() {
        Board board = new Board(4, 3);
        assertEquals(4, board.getXBoardLen());
    }

    @Test
    void getYBoardLen() {
        Board board = new Board(1, 3);
        assertEquals(3, board.getYBoardLen());
    }

    @Test
    void setEntityOnBoard() {
        int xLen = 6;
        int yLen = 3;
        Board board = new Board(xLen, yLen);
        Random rand = new Random();
        assertEquals(Board.EMPTYSPACE, board.getEntityOnBoard(rand.nextInt(xLen), rand.nextInt(yLen)));
        int xLoc = rand.nextInt(xLen);
        int yLoc = rand.nextInt(yLen);
        board.setEntityOnBoard(xLoc, yLoc, Board.ENEMY);
        assertEquals(Board.ENEMY, board.getEntityOnBoard(xLoc, yLoc));
    }
}