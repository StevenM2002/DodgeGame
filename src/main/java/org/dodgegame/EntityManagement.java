package org.dodgegame;

import java.util.ArrayList;
import java.util.Random;

public class EntityManagement {
    Board board;
    int enemyPercentageSpawn = 50;
    int pointsPercentageSpawn = 5;
    public EntityManagement(Board board) {
        this.board = board;
    }
    ArrayList<ArrayList<Enemy>> totalEnemyWave = new ArrayList<>();
    ArrayList<ArrayList<PointsObjective>> totalPointsWave = new ArrayList<>();
    private ArrayList<Enemy> generateEnemyWave() {
        ArrayList<Enemy> enemyWave = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < board.getXBoardLen(); i++) {
            if (rand.nextInt(100) < enemyPercentageSpawn) {
                enemyWave.add(new Enemy(i, 0, board));
            }
        }
        return enemyWave;
    }
    private ArrayList<PointsObjective> generatePointWave(ArrayList<Enemy> enemyWave) {
        ArrayList<PointsObjective> pointWave = new ArrayList<>();
        Random rand = new Random();
        boolean[] hasEnemy = new boolean[board.getXBoardLen()];
        for (Enemy enemy : enemyWave) {
            hasEnemy[enemy.getXLoc()] = true;
        }
        for (int i = 0; i < board.getXBoardLen(); i++) {
            // Prevent spawning points over enemies
            if (hasEnemy[i]) continue;
            // Has pointsPercentageSpawn chance of spawning on position
            if (rand.nextInt(100) < pointsPercentageSpawn) {
                pointWave.add(new PointsObjective(i, 0, board));
            }
        }
        return pointWave;
    }
    private void generateEntireWave(Player player) {
        ArrayList<Enemy> enemyWave = generateEnemyWave();
        ArrayList<PointsObjective> pointsWave = generatePointWave(enemyWave);
        totalEnemyWave.add(enemyWave);
        totalPointsWave.add(pointsWave);
        // Check and make solvable if not solvable
        ArrayList<Coord> visited = new ArrayList<>();
        if (!Dfs.isPossibleSolveWave(board, player, totalEnemyWave, visited)) {
            for (var each: visited) {
                if (each.y() == 1) {
                    removeFromWave(new Coord(each.x(), 0));
                    break;
                }
            }
        }
    }
    private void removeFromWave(Coord coord) {
        var enemyWave = totalEnemyWave.get(totalEnemyWave.size() - 1);
        for (int i = 0; i < enemyWave.size(); i++) {
            if (enemyWave.get(i).getXLoc() == coord.x()) {
                enemyWave.remove(i);
                board.setEntityOnBoard(coord.x(), 0, Board.EMPTYSPACE);
                break;
            }
        }
    }
    public void moveAllWavesUp(Player player) {
        // Separate into 2 foreach loops instead of 1 fori loop for better time complexity
        for (ArrayList<Enemy> enemyWave : totalEnemyWave) {
            for (Enemy enemy : enemyWave) {
                enemy.moveUp();
            }
        }
        for (ArrayList<PointsObjective> pointsWave : totalPointsWave) {
            for (PointsObjective pointsObjective : pointsWave) {
                pointsObjective.moveUp();
            }
        }
        // Generate after wave movement for free slot
        generateEntireWave(player);
        // Remove out of screen wave for garbage collector
        if (totalPointsWave.size() > board.getYBoardLen()) {
            totalEnemyWave.remove(0);
            totalPointsWave.remove(0);
        }
        player.ifAnyWaveCollision(totalEnemyWave.get(0), totalPointsWave.get(0));
    }

    public ArrayList<ArrayList<Enemy>> getTotalEnemyWave() {
        return totalEnemyWave;
    }
    public ArrayList<ArrayList<PointsObjective>> getTotalPointsWave() {
        return totalPointsWave;
    }
}
