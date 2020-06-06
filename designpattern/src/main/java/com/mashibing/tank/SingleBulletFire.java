package com.mashibing.tank;

public class SingleBulletFire implements Fire {

    public void fire(TankFrame tf,Dir dir,Group group, int x, int y) {
        tf.bullets.add(new Bullet(x, y, dir, group, tf));
    }
}
