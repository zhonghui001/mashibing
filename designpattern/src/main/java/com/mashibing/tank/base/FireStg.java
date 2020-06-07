package com.mashibing.tank.base;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

public interface FireStg {
    void fire(TankFrame tf, Dir dir, Group group, int x, int y);
}
