package org.dodgegame;

public class PointsObjective extends Entity {
    Board board;
    public PointsObjective(int xSpawn, int ySpawn, Board board) {
        super(xSpawn, ySpawn);
        assert isInBoard(board);
        this.board = board;
        board.setEntityOnBoard(xSpawn, ySpawn, Board.POINTOBJECTIVE);
    }
    @Override
    public void moveUp() {
        if (isInBoard(board) && board.getEntityOnBoard(getXLoc(), getYLoc()) == Board.POINTOBJECTIVE) board.setEntityOnBoard(getXLoc(), getYLoc(), Board.EMPTYSPACE);
        super.moveUp();
        if (isInBoard(board) && board.getEntityOnBoard(getXLoc(), getYLoc()) != Board.PLAYER) {
            board.setEntityOnBoard(getXLoc(), getYLoc(), Board.POINTOBJECTIVE);
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
