package org.dodgegame;

import java.util.ArrayList;
import java.util.Random;

public class EntityManagement {
    Board board;
    int enemyPercentageSpawn = 30;
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
        for (int i = 0; i < enemyWave.size(); i++) {
            hasEnemy[enemyWave.get(i).getXLoc()] = true;
        }
        for (int i = 0; i < board.getXBoardLen(); i++) {
            // Prevent spawning points over enemies
            if (hasEnemy[i]) continue;
            // Has pointsPercentageSpawn chance of spawning on position
            if (rand.nextInt(100) < pointsPercentageSpawn) {
                System.out.println("AA");
                pointWave.add(new PointsObjective(i, 0, board));
            }
        }
        return pointWave;
    }
    private void generateEntireWave() {
        ArrayList<Enemy> enemyWave = generateEnemyWave();
        ArrayList<PointsObjective> pointsWave = generatePointWave(enemyWave);
        totalEnemyWave.add(enemyWave);
        totalPointsWave.add(pointsWave);
    }
    public void moveAllWavesUp(Player player) {
        // Separate into 2 foreach loops instead of 1 fori loop for better time complexity
        for (ArrayList<Enemy> enemyWave : totalEnemyWave) {
            for (Enemy enemy : enemyWave) {
                enemy.moveUp();
//                player.ifEnemyCollision(enemy);
            }
        }
        for (ArrayList<PointsObjective> pointsWave : totalPointsWave) {
            ArrayList<Integer> buf = new ArrayList<>();
            for (int i = 0; i < pointsWave.size(); i++) {
                pointsWave.get(i).moveUp();
//                if (player.isIfPointsCollision(pointsWave.get(i))) {
//                    buf.add(i);
//                }
            }
//            for (int i : buf) {
//                pointsWave.remove(i);
//            }
        }
        // Generate after wave movement for free slot
        generateEntireWave();
        // Remove out of screen wave for garbage collector
        if (totalPointsWave.size() > board.getYBoardLen()) {
            totalEnemyWave.remove(0);
            totalPointsWave.remove(0);
        }
        player.ifAnyWaveCollision(totalEnemyWave.get(0), totalPointsWave.get(0));
    }
}