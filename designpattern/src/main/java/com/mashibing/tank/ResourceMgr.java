package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL=null,tankU=null,tankR=null,tankD=null;

    static{
        try {
            tankL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankL.gif"));
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankU.gif"));
            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankR.gif"));
            tankD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
