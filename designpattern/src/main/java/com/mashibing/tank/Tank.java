package com.mashibing.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 封装一个坦克类
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static int SPEED = 5;

    private boolean moving=false;
    private boolean living=true;

    private TankFrame tf;

    public static  int WIDTH=ResourceMgr.tankD.getWidth(),HEIGHT=ResourceMgr.tankD.getHeight();

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

        if(!living) tf.tanks.remove(this);
        //画一个矩形
        Color c = g.getColor();
        BufferedImage bm=null;
        switch (dir){
            case DOWN:
                bm=ResourceMgr.tankD;
                break;
            case UP:
                bm=ResourceMgr.tankU;
                break;
            case RIGHT:
                bm=ResourceMgr.tankR;
                break;
            case LEFT:
                bm=ResourceMgr.tankL;
                break;
        }

        g.drawImage(bm,x,y,null);
        g.setColor(c);
        move();
    }

    public void fire(){
        int x1=this.x+WIDTH/2-Bullet.WIDTH/2;
        int y1=this.y+HEIGHT/2-Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(x1,y1,this.dir,tf));
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

    public void die(){
        living=false;
    }
}
