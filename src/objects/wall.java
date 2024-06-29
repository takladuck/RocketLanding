package objects;

import render.Renderable;
import update.Updateable;

import java.awt.image.BufferedImage;
import java.util.function.UnaryOperator;

public class wall implements Renderable, Updateable {
    private static int layer =1;
    private static double width  = 100;
    private static double height = 150;
    private double x , y;
    private BufferedImage wallimage;

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
        return wallimage;
    }

    @Override
    public void update() {

    }

    @Override
    public String getID() {
        return "wall";
    }

    @Override
    public Renderable getRenderable() {
        return this;
    }
}
