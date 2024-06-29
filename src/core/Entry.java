package core;

import objects.Spaceship;
import objects.background;
import render.Renderer;
import update.Updater;

import java.io.IOException;

public class Entry {
    public static void main(String[] args) {
        Window window = new Window("DrRocket", Window.getWinWidth(), Window.getWinHeight());

        Renderer renderer = new Renderer();

        Updater updater = new Updater();


        window.addKeyListener(new input());
        window.add(renderer);

        window.packWindow();

        window.setVisible(true);

        boolean runGame = true;

        try {
            new Spaceship(125,175);
            new background(0,0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FPS.calacBeginTime();
        while (runGame) {
            renderer.repaint();
            updater.update();
            renderer.repaint();
            FPS.calacDeltaTime();

        }
    }
}
