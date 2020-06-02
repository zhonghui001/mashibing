package com.mashibing.tank;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ImageTest {

    @Test
    public void test() throws IOException {
        BufferedImage io = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("image/0.gif"));
        Assert.assertNotNull(io);
    }
}
