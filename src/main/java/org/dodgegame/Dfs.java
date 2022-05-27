package org.dodgegame;

import java.util.ArrayList;
class DfsArgs {
    public int x;
    public int y;
    public ArrayList<Coord> visited;
    public boolean[] canReachEnd;
    public Board board;
    public DfsArgs(int x, int y, ArrayList<Coord> visited, boolean[] canReachEnd, Board board) {
        this.x = x;
        this.y = y;
        this.visited = visited;
        this.canReachEnd = canReachEnd;
        this.board = board;
    }
}

public class Dfs {
    public static boolean isPossibleSolve(Board board, Player player) {
        ArrayList<Coord> visited = new ArrayList<>();
        boolean[] canReachEnd = new boolean[1];
        canReachEnd[0] = false;
        DfsArgs args = new DfsArgs(player.getXLoc(), player.getYLoc(), visited, canReachEnd, board);
        doDfs(args);
        return canReachEnd[0];
    }

    private static void doDfs(DfsArgs args) {
        var visited = args.visited;
        var x = args.x;
        var y = args.y;
        var board = args.board;
        var canReachEnd = args.canReachEnd;
        visited.add(new Coord(x, y));
        if (y == 0) {
            canReachEnd[0] = true;
            return;
        }

        if (board.getEntityOnBoard(x, y - 1) != Board.ENEMY && board.isInBoard(x, y - 1) && !visited.contains(new Coord(x, y - 1))) {
            args.y--;
            doDfs(args);
        }
        if (board.getEntityOnBoard(x - 1, y) != Board.ENEMY && board.isInBoard(x - 1, y) && !visited.contains(new Coord( x - 1, y))) {
            args.x--;
            doDfs(args);
        }
        if (board.getEntityOnBoard(x + 1, y) != Board.ENEMY && board.isInBoard(x + 1, y) && !visited.contains(new Coord(x + 1, y))) {
            args.x++;
            doDfs(args);
        }
    }
}
