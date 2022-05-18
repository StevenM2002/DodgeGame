package org.dodgegame;

public class Enemy extends Entity {
    Board board;
    public Enemy(int xSpawn, int ySpawn, Board board) {
        super(xSpawn, ySpawn);
        assert this.isInBoard(board);
        this.board = board;
    }

    @Override
    public void moveUp() {
        super.moveDown();
        if (!isInBoard(board)) {
            super.moveUp();
        }
    }

    @Override
    public void moveLeft() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveRight() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException();
    }
}
