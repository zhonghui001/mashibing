package com.mashibing.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explode {

    private int x,y;
    public static  int WIDTH=ResourceMgr.explodes[0].getWidth(),
            HEIGHT=ResourceMgr.explodes[0].getHeight();

    private boolean living =true;
    TankFrame tf;

    private int step=0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf=tf;

    }

    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step>=ResourceMgr.explodes.length) step=0;
    }




}
