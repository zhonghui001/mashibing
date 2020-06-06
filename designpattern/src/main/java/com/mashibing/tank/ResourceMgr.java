package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage goodTankL = null, goodTankU = null, goodTankR = null, goodTankD = null;
    public static BufferedImage badTankL = null, badTankU = null, badTankR = null, badTankD = null;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/GoodTank1.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);
            goodTankL = ImageUtil.rotateImage(goodTankU, 270);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            badTankL = ImageUtil.rotateImage(badTankU, 270);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, 270);

            for (int i = 1; i <= 16; i++) {
                explodes[i - 1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/e" + i + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
