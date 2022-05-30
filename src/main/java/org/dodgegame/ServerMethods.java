package org.dodgegame;

public class ServerMethods {
    private enum Movement {
        LEFT,
        RIGHT
    }
    private Board board;
    private EntityManagement entityManagement;
    private Player player;
    public void init() {
        int rowLen = 10;
        int colLen = 6;
        this.board = new Board(rowLen, colLen);
        this.entityManagement = new EntityManagement(board);
        this.player = new Player(colLen / 2, rowLen / 2, board);
    }
    public int[][] progressWaves() {
        entityManagement.moveAllWavesUp(player);
        return board.getTheBoard();
    }
    public int[][] movePlayer(Movement movement) {
        switch (movement) {
            case LEFT -> player.moveLeft();
            case RIGHT -> player.moveRight();
        }
        return board.getTheBoard();
    }
    public int[][] getBoard() {
        return board.getTheBoard();
    }


}
