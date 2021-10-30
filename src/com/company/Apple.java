package com.company;

public class Apple {
    private  int apple_x;
    private int apple_y;

    public Apple(){
        this.apple_x = 19;
        this.apple_y = 9;
    }
    public Apple(int apple_x, int apple_y){
        this.apple_x = apple_x;
        this.apple_y = apple_y;
    }
    public int getApple_x(){
        return apple_x;
    }
    public int getApple_y(){
        return apple_y;
    }
    public void setApple_x(int apple_x){
        this.apple_x = apple_x;
    }
    public void setApple_y(int apple_y){
        this.apple_y = apple_y;
    }
    public Field[][] generateNewPosition(Field[][] field){
       int x, y;


       while (true){
           x = (int)(Math.random() * (23 - 1) + 1);
           y = (int)(Math.random() * (98 - 1) + 1);
           if (field[x][y] == Field.EMPTY && field[x + 1][y] != Field.SNAKE_TAIL &&
                   field[x - 1][y] != Field.SNAKE_TAIL && field[x][y + 1] != Field.SNAKE_TAIL &&
                   field[x][y - 1] != Field.SNAKE_TAIL){
               field[x][y] = Field.APPLE;
               setApple_x(x);
               setApple_y(y);
               return field;
           }

       }
    }
}
