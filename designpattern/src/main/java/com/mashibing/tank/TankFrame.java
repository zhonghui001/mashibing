package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    public TankFrame(){
        this.setSize(800,600);
        this.setResizable(false); //不能改变大小
        this.setTitle("tank war");
        this.setVisible(true);

        //添加关闭的事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        //画一个矩形
        g.fillRect(200,200,50,50);
    }
}
