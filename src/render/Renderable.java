package render;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Renderable extends Comparable<Object>{
    public int getLayer();
    public double getX();
    public double getY();
    public double getWidth();
    public double getHeight();
    public BufferedImage getBufferedImage();
    public default void drawSprite(Graphics2D g) {
        g.drawImage(getBufferedImage(),(int)getX(),(int)getY(),(int)getWidth(),(int)getHeight(),null);
    }
    public default int compareTo(Object o) {
        Renderable object = (Renderable) o;
        if (this.getLayer() < object.getLayer()){
            return -1;
        }
        else if (this.getLayer() > object.getLayer()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
