package org.dodgegame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void isOutOfBoard() {
        int xLen = 8;
        int yLen = 11;
        Board board = new Board(xLen, yLen);
        Entity entity = new Entity(9, 0);
        assertFalse(entity.isInBoard(board));
        Entity entity1 = new Entity(5, 2);
        assertTrue(entity1.isInBoard(board));
        Entity entity2 = new Entity(10, 10);
        assertFalse(entity2.isInBoard(board));
        Entity entity3 = new Entity(4,-3);
        assertFalse(entity3.isInBoard(board));
    }

    @Test
    void movement() {
        Entity entity = new Entity(0, 5);
        assertEquals(5, entity.getYLoc());
        entity.moveDown();
        assertEquals(4, entity.getYLoc());
        assertEquals(0, entity.getXLoc());
        entity.moveUp();
        assertEquals(5, entity.getYLoc());
        entity.moveUp();
        assertEquals(6, entity.getYLoc());
        entity.moveLeft();
        assertEquals(-1, entity.getXLoc());
        entity.moveRight();
        entity.moveRight();
        assertEquals(1, entity.getXLoc());
    }


}