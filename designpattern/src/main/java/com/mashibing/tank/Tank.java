package com.mashibing.tank;

import java.awt.*;

/**
 * 封装一个坦克类
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static int SPEED = 5;

    private boolean moving=false;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir=dir;
    }

    public void paint(Graphics g){
        //画一个矩形
        g.fillRect(x,y,50,50);
        move();
    }

    private void move() {
        if(!moving) return;

        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }
    }
}
