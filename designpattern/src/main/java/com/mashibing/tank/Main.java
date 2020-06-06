package com.mashibing.tank;

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

        int initTankCount=Integer.parseInt((String)PropertyMgr.get("initTankCount"));

        //初始化地方坦克
        for (int i = 0; i < initTankCount; i++) {
            tf.tanks.add(new Tank(50 + i * 70, 200, Dir.DOWN, Group.BAD, tf));
        }

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
