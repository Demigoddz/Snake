package com.company;

import javax.swing.border.EmptyBorder;
import java.time.Duration;
import java.util.Locale;
import java.util.Scanner;

enum Field {
    //    Empty == 0
    EMPTY,
    SNAKE_TAIL,
    SNAKE_BODY,
    SNAKE_HEAD,
    APPLE,
    BORDER
}

public class FieldOfPlay {
    private Field[][] field;

    public FieldOfPlay() {
        this.field = new Field[25][100];
        for (int i = 0; i < field.length; i++){
            for (int j = 0;j < field[i].length; j++){
                this.field[i][j] = Field.EMPTY;
            }
        }
        for (int i = 0; i < field[0].length; i++) {
            this.field[0][i] = Field.BORDER;
        }
        for (int i = 0; i < field.length; i++){
            this.field[i][0] = Field.BORDER;
        }
        for (int i = 0; i < field.length; i++){
            this.field[i][99] = Field.BORDER;
        }
        for (int i = 0;i < field[0].length; i++){
            this.field[24][i] = Field.BORDER;
        }
        this.field[19][9] = Field.APPLE;
        this.field[15][74] = Field.SNAKE_HEAD;

    }

    public FieldOfPlay(Field[][] field) {
        this.field = field;
    }

    public Field[][] getField() {
        return field;
    }

    public void setField(Field[][] field) {
        this.field = field;
    }

    public boolean checkLose(Direction direction){
        int x = -1, y = -1;
        for (int i = 0;i < field.length;  i++){
            for (int j = 0; j < field[i].length; j++){
                if (field[i][j] == Field.SNAKE_HEAD){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (direction == Direction.Up){
            if (field[x - 1][y] == Field.BORDER || field[x - 1][y] == Field.SNAKE_BODY ||
                    field[x - 1][y] == Field.SNAKE_TAIL){
                return true;
            }
        }
        if (direction == Direction.Down){
            if (field[x + 1][y] == Field.BORDER || field[x + 1][y] == Field.SNAKE_BODY ||
                    field[x + 1][y] == Field.SNAKE_TAIL){
                return true;
            }
        }
        if (direction == Direction.Left){
            if (field[x][y - 1] == Field.BORDER || field[x][y - 1] == Field.SNAKE_BODY ||
                    field[x][y - 1] == Field.SNAKE_TAIL){
                return true;
            }
        }
        if (direction == Direction.Right){
            if (field[x][y + 1] == Field.BORDER || field[x][y + 1] == Field.SNAKE_BODY ||
                    field[x][y + 1] == Field.SNAKE_TAIL){
                return true;
            }
        }
        return false;
    }

    public Direction snakeMove(Direction pastDirection){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your direction: w, a, s, d");
        String direction = sc.next();
        if (direction.toLowerCase(Locale.ROOT).equals("w")) return Direction.Up;
        if (direction.toLowerCase(Locale.ROOT).equals("a")) return Direction.Left;
        if (direction.toLowerCase(Locale.ROOT).equals("s")) return Direction.Down;
        if (direction.toLowerCase(Locale.ROOT).equals("d")) return Direction.Right;
        return snakeMove(pastDirection);
    }
}
