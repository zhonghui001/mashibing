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

    private TankFrame tf;

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

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir=dir;
        this.tf=tankFrame;
    }

    public void paint(Graphics g){
        //画一个矩形
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x,y,50,50);
        g.setColor(c);
        move();
    }

    public void fire(){
        tf.b=new Bullet(this.x,this.y,this.dir);
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
