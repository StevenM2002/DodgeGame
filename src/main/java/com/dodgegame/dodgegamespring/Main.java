package com.dodgegame.dodgegamespring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class Main {
    public static void lame(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping
    public String test() {
        return "Hello World";
    }
//    public static void main(String[] args) {
////        int rowLen = 7;
////        int colLen = 6;
////        Board board = new Board(rowLen, colLen);
////        EntityManagement entityManagement = new EntityManagement(board);
////        Player player = new Player(colLen / 2, rowLen - 1, board);
////        entityManagement.moveAllWavesUp(player);
////        board.printBoard();
////        entityManagement.moveAllWavesUp(player);
//////        entityManagement.moveAllWavesUp(player);
////        board.printBoard();
////        entityManagement.moveAllWavesUp(player);
////        board.printBoard();
////        entityManagement.moveAllWavesUp(player);
////        board.printBoard();
////        System.out.println(Dfs.isPossibleSolve(board, player));
////        board.printBoard();
////        Scanner sc = new Scanner(System.in);
////        String x = sc.next();
////        while (!x.equals("x")) {
////            if (x.equals("1")) {
////                player.moveLeft();
////            } else if (x.equals("3")) {
////                player.moveRight();
////            }
////            player.ifAnyWaveCollision(entityManagement.getTotalEnemyWave().get(0),
////                    entityManagement.getTotalPointsWave().get(0));
////            entityManagement.moveAllWavesUp(player);
////            System.out.println(player.getPoints());
////            board.printBoard();
////            x = sc.next();
////        }
//    }
}