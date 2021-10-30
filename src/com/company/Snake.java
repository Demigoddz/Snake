package com.company;


import java.util.ArrayList;
import java.util.List;

public class Snake {
    private int head_x;
    private int head_y;
    private int tail_x;
    private int tail_y;
    private int length;
    private ArrayList<SnakePosition> SnakePositionHistory;



    public Snake() {
        this.head_x = 0;
        this.head_y = 0;
        this.tail_x = 0;
        this.tail_y = 0;
        this.SnakePositionHistory = new ArrayList<>();
        length = 1;
    }

    public Snake(int head_x, int head_y, int tail_x, int tail_y, ArrayList<SnakePosition> snakePositionHistory,
                 int length) {
        this.head_x = 0;
        this.head_y = 0;
        this.tail_x = 0;
        this.tail_y = 0;
        this.SnakePositionHistory = new ArrayList<>();
        this.length = 1;
    }

    public int getHead_x() {
        return head_x;
    }

    public int getHead_y() {
        return head_y;
    }

    public int getTail_x() {
        return tail_x;
    }

    public int getTail_y() {
        return tail_y;
    }

    public List<SnakePosition> getSnakePositionHistory() {
        return SnakePositionHistory;
    }

    public ArrayList<SnakePosition> getSnakePosition() {

        return SnakePositionHistory;
    }

    public int getLength() {
        return length;
    }

    public void setHead_x(int head_x) {
        this.head_x = 0;
    }

    public void setHead_y(int head_y) {
        this.head_y = 0;
    }

    public void setTail_x(int tail_x) {
        this.tail_x = 0;
    }

    public void setTail_y(int tail_y) {
        this.tail_y = 0;
    }

    public void setSnakePositionHistory(ArrayList<SnakePosition> snakePositionHistory) {
        this.SnakePositionHistory = snakePositionHistory;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Field[][] move(Field[][] fields, Apple apple, Direction direction, Game game) {
        int x = -1, y = -1;

        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j] == Field.SNAKE_HEAD) {
                    x = i;
                    y = j;
                }
            }
        }
        if (direction == Direction.Up) {
            head_y = y;
            head_x = x - 1;
            addSnakePosition(new SnakePosition(x - 1, y));
            if (fields[x - 1][y] == Field.SNAKE_BODY || fields[x - 1][y] == Field.BORDER || fields[x - 1][y] == Field.SNAKE_TAIL) {
                game.endGame();
            } else if (fields[x - 1][y] == Field.APPLE) {
                fields = eatApple(fields, Direction.Up, apple);
                return fields;
            } else if (fields[x - 1][y] == Field.EMPTY) {
                if (length == 1){
                    fields[x][y] = Field.EMPTY;
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    tail_x = head_x;
                    tail_y = head_y;
                    return fields;
                }
                if (length == 2){
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x + 1][head_y] = Field.SNAKE_TAIL;
                    tail_x = head_x + 1;
                    tail_y = head_y;
                    fields[getSnakePosition().get(getSnakePosition().size() - length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }
                if (length >= 3){
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x + 1][head_y] = Field.SNAKE_BODY;
                    fields[getSnakePosition().get(getSnakePosition().size() - length).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length).getY()] = Field.SNAKE_TAIL;
                    fields[getSnakePosition().get(getSnakePosition().size() - length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }
            }
        }
        if (direction == Direction.Down) {
            head_x = x + 1;
            head_y = y;
            addSnakePosition(new SnakePosition(x + 1, y));
            if (fields[x + 1][y] == Field.BORDER || fields[x + 1][y] == Field.SNAKE_BODY || fields[x + 1][y] == Field.SNAKE_TAIL) {
                game.endGame();
            }
            else if (fields[x + 1][y] == Field.APPLE) {
                fields = eatApple(fields, Direction.Down, apple);
                return fields;
            } else if (fields[x + 1][y] == Field.EMPTY) {
                for (int k = 0; k < fields.length; k++) {
                    for (int a = 0; a < fields[k].length; a++) {
                        if (fields[k][a] == Field.SNAKE_HEAD) {
                            x = k;
                            y = a;
                        }
                    }
                }
                if (length == 1){
                    fields[x][y] = Field.EMPTY;
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    tail_x = head_x;
                    tail_y = head_y;
                    return fields;
                }
                if (length == 2){
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x - 1][head_y] = Field.SNAKE_TAIL;
                    tail_x = head_x -1;
                    tail_y = head_y;
                    fields[getSnakePosition().get(getSnakePosition().size() - length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }
                if (length >= 3){

                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x - 1][head_y] = Field.SNAKE_BODY;
                    fields[getSnakePosition().get(getSnakePosition().size() - length).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length).getY()] = Field.SNAKE_TAIL;
                    fields[getSnakePosition().get(getSnakePosition().size() - length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }
            }
        }
        if (direction == Direction.Left) {

            head_x = x;
            head_y = y - 1;
            addSnakePosition(new SnakePosition(x, y - 1));
            if (fields[x][y - 1] == Field.SNAKE_BODY || fields[x][y - 1] == Field.BORDER || fields[x][y -1] == Field.SNAKE_TAIL) {
                game.endGame();
            }
            else if (fields[x][y - 1] == Field.APPLE) {
                fields = eatApple(fields, Direction.Left, apple);
                return fields;
            }
            else if (fields[x][y - 1] == Field.EMPTY) {
                for (int k = 0; k < fields.length; k++) {
                    for (int a = 0; a < fields[k].length; a++) {
                        if (fields[k][a] == Field.SNAKE_HEAD) {
                            x = k;
                            y = a;
                        }
                    }
                }
                if (length == 1){
                    fields[x][y] = Field.EMPTY;
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    tail_x = head_x;
                    tail_y = head_y;
                    return fields;
                }
                if (length == 2){
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x][head_y + 1] = Field.SNAKE_TAIL;
                    tail_x = head_x;
                    tail_y = head_y + 1;
                    fields[getSnakePosition().get(getSnakePosition().size() - length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }
                if (length >= 3){
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x][head_y + 1] = Field.SNAKE_BODY;
                    fields[getSnakePosition().get(getSnakePosition().size() - length).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length).getY()] = Field.SNAKE_TAIL;
                    fields[getSnakePosition().get(getSnakePosition().size() - length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }
            }
        }
        if (direction == Direction.Right) {
            head_x = x;
            head_y = y + 1;
            addSnakePosition(new SnakePosition(x, y + 1));
            if (fields[x][y + 1] == Field.SNAKE_BODY || fields[x][y + 1] == Field.BORDER || fields[x][y + 1] == Field.SNAKE_TAIL) {
                 game.endGame();
            }
            else if (fields[x][y + 1] == Field.APPLE) {
                fields = eatApple(fields, Direction.Right, apple);
                return fields;
            } else if (fields[x][y + 1] == Field.EMPTY) {
                for (int k = 0; k < fields.length; k++) {
                    for (int a = 0; a < fields[k].length; a++) {
                        if (fields[k][a] == Field.SNAKE_HEAD) {
                            x = k;
                            y = a;
                        }
                    }
                }
                if (length == 1){
                    fields[x][y] = Field.EMPTY;
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    tail_x = head_x;
                    tail_y =  head_y;
                    return fields;
                }
                if (length == 2){
                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x][head_y - 1] = Field.SNAKE_TAIL;
                    tail_x = head_x;
                    tail_y = head_y - 1;
                    fields[getSnakePosition().get(getSnakePosition().size() -  length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }
                if (length >= 3){

                    fields[head_x][head_y] = Field.SNAKE_HEAD;
                    fields[head_x][head_y - 1] = Field.SNAKE_BODY;
                    fields[SnakePositionHistory.get(getSnakePosition().size() - length).getX()]
                            [SnakePositionHistory.get(getSnakePosition().size() - length).getY()] = Field.SNAKE_TAIL;
                    fields[getSnakePosition().get(getSnakePosition().size() - length - 1).getX()]
                            [getSnakePosition().get(getSnakePosition().size() - length - 1).getY()] = Field.EMPTY;
                    return fields;
                }

                fields[tail_x][tail_y] = Field.EMPTY;
                tail_x = SnakePositionHistory.get(getSnakePosition().size() - length).getX();
                tail_y = SnakePositionHistory.get(getSnakePosition().size() - length).getY();
            }
        }
        return fields;
    }

    //ЛОГИРОВАНИЕ ДВИЖЕНИЯ
    public void addSnakePosition(SnakePosition snakePosition) {
        SnakePositionHistory.add(snakePosition);
    }

    //поедание яблока
    public Field[][] eatApple(Field[][] field, Direction direction, Apple apple) {
        int x = head_x, y = head_y;
        if (head_x == apple.getApple_x() && head_y == apple.getApple_y()) {
            field = apple.generateNewPosition(field);
            if (direction == Direction.Up) {
                if (field[x - 1][y] == Field.BORDER || field[x - 1][y] == Field.SNAKE_BODY) {
                } else if (length == 1) {
                    field[x + 1][y] = Field.SNAKE_TAIL;
                    field[head_x][head_y] = Field.SNAKE_HEAD;
                    length++;
                    return field;
                }

                if (length >= 2){
                    field[head_x][head_y] = Field.SNAKE_HEAD;
                    field[head_x + 1][head_y] = Field.SNAKE_BODY;

                    length++;
                    return field;
                }
            }
            if (direction == Direction.Down) {
                if (field[x + 1][y] == Field.SNAKE_BODY || field[x + 1][y] == Field.BORDER) {
                } else if (length == 1) {
                    field[x - 1][y] = Field.SNAKE_TAIL;
                    field[head_x][head_y] = Field.SNAKE_HEAD;
                    length++;
                    return field;
                }

                if (length >= 2){
                    field[head_x][head_y] = Field.SNAKE_HEAD;
                    field[head_x - 1][head_y] = Field.SNAKE_BODY;


                    length++;
                    return field;
                }
            }
            if (direction == Direction.Left) {
                if (field[x][y - 1] == Field.SNAKE_BODY || field[x][y - 1] == Field.BORDER) {
                } else if (length == 1) {
                    field[x][y + 1] = Field.SNAKE_TAIL;
                    field[head_x][head_y ] = Field.SNAKE_HEAD;
                    length++;
                    return field;
                }


                if (length >= 2){
                    field[head_x][head_y] = Field.SNAKE_HEAD;
                    field[head_x][head_y + 1] = Field.SNAKE_BODY;
                    length++;
                    return field;
                }
            }
            if (direction == Direction.Right) {
                if (field[x][y + 1] == Field.SNAKE_BODY || field[x][y + 1] == Field.BORDER) {
                } else if (length == 1) {
                    field[x][y - 1] = Field.SNAKE_TAIL;
                    field[head_x][head_y] = Field.SNAKE_HEAD;
                    length++;
                    return field;
                }

                if (length >= 2){
                    field[head_x][head_y] = Field.SNAKE_HEAD;
                    field[head_x][head_y - 1] = Field.SNAKE_BODY;
                    length++;
                    return field;
                }
            }
        }
        length++;
        Main.speed -= 10;
        return field;
    }
}
