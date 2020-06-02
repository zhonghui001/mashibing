package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    static final int GAME_WIDTH=800,GAME_HEIGHT=600;
    Tank myTank=new Tank(400,200,Dir.DOWN,this);
    List<Tank> tanks=new ArrayList<Tank>();
    List<Bullet> bullets = new ArrayList<Bullet>();

    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        this.setResizable(false); //不能改变大小
        this.setTitle("tank war");
        this.setVisible(true);

        this.addKeyListener(new MyKeyListener());

        //添加关闭的事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
       myTank.paint(g);
//       for(Bullet b:bullets){
////           b.paint(g);
////       }
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }

        for(int i=0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }


    }

    class MyKeyListener extends KeyAdapter{
        boolean bU=false;
        boolean bL=false;
        boolean bR=false;
        boolean bD=false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir(){
            if(!bL && !bR && !bU && !bD) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
            }

        }
    }
}
