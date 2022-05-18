package org.dodgegame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> t = new ArrayList<>();
        Board board = new Board(6, 4);
        EntityManagement entityManagement = new EntityManagement(board);
        Player player = new Player(2, 5, board);
        board.printBoard();
        for (int i = 0; i < board.getYBoardLen(); i++) {
            entityManagement.moveAllWavesUp(player);
            System.out.println(player.getPoints());
            board.printBoard();
        }
    }
}