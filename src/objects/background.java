package objects;

import render.Renderable;
import render.Renderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class background implements Renderable {
    private int layer = 0;
    private static double width  = 1280;
    private static double height = 720;
    private double x , y;

    private  static BufferedImage backGround;

    public background(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        backGround = ImageIO.read(new File("./res/background.png"));
        Renderer.addRendedrableObject(this);
    }


    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return backGround;
    }
}
