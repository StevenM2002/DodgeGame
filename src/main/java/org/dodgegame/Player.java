package org.dodgegame;

public class Player extends Entity {
    Board board;
    int points = 0;
    int pointsGain = 100;
    public Player(int xSpawn, int ySpawn, Board board) {
        super(xSpawn, ySpawn);
        assert isInBoard(board);
        this.board = board;
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

    public void ifEnemyCollision(Enemy enemy) {
        if (enemy.getXLoc() == this.getXLoc() && enemy.getYLoc() == this.getYLoc()) {
            System.out.println("You have lost");
            board.setEntityOnBoard(this.getXLoc(), this.getYLoc(), Board.COLLISION);
            board.printBoard();
            System.exit(0);
        }
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException();
    }
}
