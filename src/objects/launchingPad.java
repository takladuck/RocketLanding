package objects;

import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class launchingPad implements Renderable, Updateable {
    private static double width  = 150;
    private static double height = 20;
    private double x , y;
    private int layer =2;
    public static BufferedImage landingpad;

    public launchingPad(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        landingpad = ImageIO.read(new File("./res/launching.png"));
        Renderer.addRendedrableObject(this);
        Updater.addUpdateableObjects(this);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
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
        return landingpad;
    }

    @Override
    public void update() {
    }

    @Override
    public String getID() {
        return "launchingpad";
    }

    @Override
    public Renderable getRenderable() {
        return this;
    }
}
