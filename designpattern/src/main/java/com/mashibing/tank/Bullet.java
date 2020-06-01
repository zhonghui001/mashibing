package com.mashibing.tank;

import java.awt.*;

public class Bullet {

    private static final int SPEED = 8;
    private int x,y;
    private Dir dir;
    private static  int WIDTH=20,HEIGHT=20;

    private boolean live=true;
    TankFrame tf;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;

    }

    public void paint(Graphics g){
        if (!live){
            tf.bullets.remove(this);
            return;
        }
        //画一个矩形
        Color c=g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
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

        if (x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT){
            live=false;
        }
    }
}
