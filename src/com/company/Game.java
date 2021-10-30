package com.company;
enum Direction{
    Left,
    Down,
    Up,
    Right
}

public class Game {
    private Player player;
    private Snake snake;
    private FieldOfPlay fieldOfPlay;
    private Apple apple;
    private boolean isGameEnd = false;

    public Game(){
        this.player = new Player();
        this.snake = new Snake();
        this.fieldOfPlay = new FieldOfPlay();
        this.apple = new Apple();
    }
    public Game (Player player, Snake snake, FieldOfPlay fieldOfPlay, Apple apple){
        this.player = player;
        this.snake = snake;
        this.fieldOfPlay = fieldOfPlay;
        this.apple = apple;
    }
    public Player getPlayer(){
        return player;
    }
    public Snake getSnake(){
        return snake;
    }
    public FieldOfPlay getFieldOfPlay(){
        return fieldOfPlay;
    }
    public Apple getApple(){
        return apple;
    }
    public boolean getIsGameEnd(){
        return isGameEnd;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public void setSnake(Snake snake){
        this.snake = snake;
    }
    public void  setFieldOfPlay(FieldOfPlay fieldOfPlay){
        this.fieldOfPlay = fieldOfPlay;
    }
    public void setApple(Apple apple){
        this.apple = apple;
    }
    public void paintField()
    {
        for (int i = 0;i < fieldOfPlay.getField().length; i++){
            for (int j = 0;j < fieldOfPlay.getField()[i].length; j++){
                if(fieldOfPlay.getField()[i][j] == Field.EMPTY){
                    System.out.print(" ");
                }
                else if (fieldOfPlay.getField()[i][j] == Field.BORDER){
                    System.out.print("#");
                }
                else if (fieldOfPlay.getField()[i][j] == Field.APPLE){
                    System.out.print("@");
                }
                else if (fieldOfPlay.getField()[i][j] == Field.SNAKE_HEAD){
                    System.out.print("*");
                }
                else if(fieldOfPlay.getField()[i][j] == Field.SNAKE_BODY){
                    System.out.print("+");
                }
                else if (fieldOfPlay.getField()[i][j] == Field.SNAKE_TAIL){
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
    public boolean isNextApple(Direction direction){
        int  x = - 1, y = - 1;
        for (int i = 0;i < fieldOfPlay.getField().length; i++){
            for (int j = 0;j < fieldOfPlay.getField()[i].length; j++){
                if (fieldOfPlay.getField()[i][j] == Field.SNAKE_HEAD){
                    x = i;
                    y = j;
                }
            }
        }
        if (direction == Direction.Up){
            if (fieldOfPlay.getField()[x - 1][y] == Field.APPLE){
                return true;
            }
        }
        if (direction == Direction.Down){
            if (fieldOfPlay.getField()[x + 1][y] == Field.APPLE){
                return true;
            }
        }
        if (direction == Direction.Left){
            if (fieldOfPlay.getField()[x][y - 1] == Field.APPLE){
                return true;
            }
        }
        if (direction == Direction.Right){
            if (fieldOfPlay.getField()[x][y + 1] == Field.APPLE){
                return true;
            }
        }
        return false;
    }
    public static void ClearConsole(){
        try {
            String operatingSystem = System.getProperty("os.name");
            if (operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cls","/c","cdm");
                Process StartProcess = pb.inheritIO().start();
                StartProcess.waitFor();
            }
            else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process StartProcess = pb.inheritIO().start();

                StartProcess.waitFor();
            }
        }
        catch (Exception en){
            System.out.println(en.getMessage());
        }
    }
    public void snakeMove(Field[][] fields, Apple apple, Direction direction){
        fieldOfPlay.setField(snake.move(fields, apple, direction, this));
    }
    public void endGame(){
       isGameEnd = true;
    }
}
