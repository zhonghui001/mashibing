package com.mashibing.tank;

public class FourBulletFire implements Fire {

    public FourBulletFire() {
    }

    private static class FourBulletFireHolder{
        static FourBulletFire instance=new FourBulletFire();
    }


    public void fire(TankFrame tf, Dir dir, Group group, int x, int y) {
        tf.bullets.add(new Bullet(x,y,Dir.UP,group,tf));
        tf.bullets.add(new Bullet(x,y,Dir.LEFT,group,tf));
        tf.bullets.add(new Bullet(x,y,Dir.RIGHT,group,tf));
        tf.bullets.add(new Bullet(x,y,Dir.DOWN,group,tf));
    }
}
