package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL=null,tankU=null,tankR=null,tankD=null;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static{
        try {
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/GoodTank1.png"));
            tankR= ImageUtil.rotateImage(tankU,90);
            tankD= ImageUtil.rotateImage(tankU,180);
            tankL= ImageUtil.rotateImage(tankU,270);

            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
            bulletR= ImageUtil.rotateImage(bulletU,90);
            bulletD= ImageUtil.rotateImage(bulletU,180);
            bulletL= ImageUtil.rotateImage(bulletU,270);

            for(int i=1;i<=16;i++){
                explodes[i-1]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/e"+i+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
