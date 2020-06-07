package com.mashibing.tank.factory;

import com.mashibing.tank.*;
import com.mashibing.tank.base.BaseBullet;
import com.mashibing.tank.base.BaseExplode;
import com.mashibing.tank.base.BaseTank;

public class DefaultGameFactory extends GameFactory {

    public DefaultGameFactory() {
    }

    private static class DefaultGameFactoryHolder{
        static DefaultGameFactory instance=new DefaultGameFactory();
    }

    public GameFactory newInstance(){
        return DefaultGameFactoryHolder.instance;
    }

    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x,y,dir,group,tf);
    }

    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }

    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x,y,dir,group,tankFrame);
    }
}
