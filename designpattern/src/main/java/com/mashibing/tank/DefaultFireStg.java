package com.mashibing.tank;

import com.mashibing.tank.base.FireStg;

/**
 * 因为每次都需要new
 * 所以直接变成单例
 */
public class DefaultFireStg implements FireStg {

    private DefaultFireStg(){}

    private static class DefaultFireHolder{
       static DefaultFireStg instance=new DefaultFireStg();
    }

    public static DefaultFireStg getInstance() {
        return DefaultFireHolder.instance;
    }

    public void fire(TankFrame tf,Dir dir,Group group, int x, int y) {
        tf.bullets.add(new Bullet(x, y, dir, group, tf));
    }
}
