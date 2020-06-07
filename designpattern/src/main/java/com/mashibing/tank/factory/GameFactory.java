package com.mashibing.tank.factory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;
import com.mashibing.tank.base.BaseBullet;
import com.mashibing.tank.base.BaseExplode;
import com.mashibing.tank.base.BaseTank;

public abstract class GameFactory {

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
}
