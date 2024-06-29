package objects;

import core.FPS;
import core.input;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spaceship implements Renderable, Updateable {
    private static double width  = 55;
    private static double height = 95;
    private double x , y;
    private int layer =2;
    private double vx,vy, maxSpeed =500;
    private  double acceleration =200, deceleration=400,gravity=175;




    private  static BufferedImage currentSpaceship,spaceshipWithThruster,spaceshipWithoutThruster;


    public Spaceship(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        spaceshipWithoutThruster = ImageIO.read(new File("./res/rocket.png"));
        spaceshipWithThruster = ImageIO.read(new File("./res/rocketthruster.png"));
        currentSpaceship = spaceshipWithoutThruster;
        Renderer.addRendedrableObject(this);
        Updater.addUpdateableObjects(this);
    }

    public  double getWidth() {
        return width;
    }

    public  double getHeight() {
        return height;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return currentSpaceship;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int getLayer() {
        return layer;
    }



    @Override
    public void update() {

        FPS.calacDeltaTime();
        double deltaTime = FPS.getDeltaTime();

        if (input.keys[input.LEFT]) {
            vx -= acceleration * deltaTime;
        } else if (input.keys[input.RIGHT]) {
            vx += acceleration * deltaTime;
        } else {
            vx = Math.abs(vx) > deceleration * deltaTime ? vx - Math.signum(vx) * deceleration * deltaTime : 0;
        }

        vx = Math.min(Math.max(vx, -maxSpeed), maxSpeed);

        if (input.keys[input.DOWN]) {
            /*vy = Math.min(vy + acceleration * deltaTime, maxSpeed);*/
        } else if (input.keys[input.UP]) {
            vy = Math.max(vy - acceleration * deltaTime, -maxSpeed);
        } else {
            vy += gravity * deltaTime;
        }

        vy = Math.min(Math.max(vy, -maxSpeed), maxSpeed);

        x += vx * deltaTime;
        y += vy * deltaTime;

        boolean isAccelerating = (input.keys[input.UP] );

        if (isAccelerating) {
            currentSpaceship = spaceshipWithThruster;
        } else {
            currentSpaceship = spaceshipWithoutThruster;
        }


        if (x < 0) {
            x = 0;
            vx = 0;
        } else if (x + width > 1280) {
            x = 1280 - width;
            vx = 0;
        }

        if (y < 0) {
            y = 0;
            vy = 0;
        } else if (y + height-20 > 720) {
            y = 720 - height+20;
            vy = 0;
        }

    }

    @Override
    public String getID() {
        return "spaceship";
    }

    @Override
    public Renderable getRenderable() {
        return this;
    }
}
