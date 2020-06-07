package com.mashibing.tank;

/**
 * 因为每次都需要new
 * 所以直接变成单例
 */
public class DefaultFire implements Fire {

    private DefaultFire(){}

    private static class DefaultFireHolder{
       static DefaultFire instance=new DefaultFire();
    }

    public static DefaultFire getInstance() {
        return DefaultFireHolder.instance;
    }

    public void fire(TankFrame tf,Dir dir,Group group, int x, int y) {
        tf.bullets.add(new Bullet(x, y, dir, group, tf));
    }
}
