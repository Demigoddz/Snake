package com.company;
//щас 2 минуты


import java.lang.ref.Cleaner;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static int speed = 2000;
    public static Direction dir = Direction.Up;
    public static Game myGame;
    public static String strDirection = "w";
    public static Timer timer;
    public static long delay = 1000;
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        myGame = new Game();
        timer = new Timer("Timer");
        TimerTask task = new TimerTask() {
            public void run() {
                Scanner sc = new Scanner(System.in);
                myGame.snakeMove(myGame.getFieldOfPlay().getField(), myGame.getApple(), dir);
                myGame.paintField();
                int access = 0;
                if (myGame.getIsGameEnd()) {
                    access = 1;
                    timer.cancel();
                }
                switch (access) {
                    case 1: {
                        System.out.println("Конец игры!");
                        System.exit(0);
                    }
                    break;
                }
            }
        };


        timer.scheduleAtFixedRate(task, 0, delay);

        while (true) {

            Scanner sc = new Scanner(System.in);
            strDirection = sc.next().toLowerCase(Locale.ROOT);
            if (strDirection.equals("w") && dir != Direction.Down) dir = Direction.Up;
            else if (strDirection.equals("s") && dir != Direction.Up) dir = Direction.Down;
            else if (strDirection.equals("a") && dir != Direction.Right) dir = Direction.Left;
            else if (strDirection.equals("d") && dir != Direction.Left) dir = Direction.Right;

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
