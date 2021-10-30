package com.company;

public class SnakePosition {
    private int x;
    private int y;

    public SnakePosition() {
        x = 0;
        y = 0;
    }
    public SnakePosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

}
