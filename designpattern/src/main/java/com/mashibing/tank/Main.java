package com.mashibing.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Frame f = new Frame();
////        f.setSize(800,600);
////        f.setResizable(false); //不能改变大小
////        f.setTitle("tank war");
////        f.setVisible(true);
////
////        //添加关闭的事件
////        f.addWindowListener(new WindowAdapter() {
////            @Override
////            public void windowClosing(WindowEvent e) {
////                System.exit(0);
////            }
////        });

        TankFrame tf = new TankFrame();
        //初始化地方坦克
        for(int i=0;i<5;i++){
            tf.tanks.add(new Tank(50+i*80,200,Dir.DOWN,tf));
        }

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
