package com.mashibing.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {

    private static final int SPEED = 8;
    private int x,y;
    private Dir dir;
    private Group group=Group.BAD;
    public static  int WIDTH=ResourceMgr.bulletD.getWidth(),HEIGHT=ResourceMgr.bulletD.getHeight();

    private boolean living =true;
    TankFrame tf;

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group=group;

    }

    public void paint(Graphics g){
        if (!living){
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

        g.drawImage(bm,x+WIDTH/2,y+HEIGHT/2,null);

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
            living =false;
        }
    }

    /**
     * 碰撞检测
     * @param tank
     */
    public void collideWith(Tank tank){
        if(this.group==tank.getGroup()) return;
        //TODO :用一个
        Rectangle rectB=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectT=new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rectB.intersects(rectT)){
            tank.die();
            this.die();
            int eX=tank.getX()+Tank.WIDTH/2-Explode.WIDTH/2;
            int eY=tank.getY()+Tank.HEIGHT/2-Explode.HEIGHT/2;
            tf.explodes.add(new Explode(eX,eY,tf));
        }
    }

    public void die(){
        living=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
