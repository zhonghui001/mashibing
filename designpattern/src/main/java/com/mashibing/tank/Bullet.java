package com.mashibing.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

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

        BufferedImage bm=null;
        switch (dir){
            case DOWN:
                bm=ResourceMgr.bulletD;
                break;
            case UP:
                bm=ResourceMgr.bulletU;
                break;
            case RIGHT:
                bm=ResourceMgr.bulletR;
                break;
            case LEFT:
                bm=ResourceMgr.bulletL;
                break;
        }

        g.drawImage(bm,x,y,null);

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
