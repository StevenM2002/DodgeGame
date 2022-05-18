package org.dodgegame;

public class Enemy extends Entity {
    Board board;
    public Enemy(int colSpawn, int rowSpawn, Board board) {
        super(colSpawn, rowSpawn);
        assert this.isInBoard(board);
        this.board = board;
        board.setEntityOnBoard(colSpawn, rowSpawn, Board.ENEMY);
    }

    @Override
    public void moveUp() {
        // Ensure going to be previous entity hasn't already been set by a different entity
        // and if it isnt i.e. it is itself an ENEMY then set previous place as enemy
        if (isInBoard(board) && board.getEntityOnBoard(getXLoc(), getYLoc()) == Board.ENEMY) board.setEntityOnBoard(getXLoc(), getYLoc(), Board.EMPTYSPACE);
        super.moveUp();
        if (isInBoard(board) && board.getEntityOnBoard(getXLoc(), getYLoc()) != Board.PLAYER) {
            board.setEntityOnBoard(getXLoc(), getYLoc(), Board.ENEMY);
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
