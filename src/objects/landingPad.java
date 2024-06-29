package objects;

import render.Renderable;

import java.awt.image.BufferedImage;

public class landingPad implements Renderable {

    @Override
    public int getLayer() {
        return 0;
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
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return null;
    }
}
