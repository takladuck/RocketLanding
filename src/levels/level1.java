package levels;

import core.FPS;
import core.Window;
import core.input;
import objects.Spaceship;
import objects.background;
import objects.landingPad;

import objects.launchingPad;
import render.Renderer;
import update.Updater;

import java.io.IOException;

public class level1 {
    public void level1(){
        Window window = new Window("DrRocket", Window.getWinWidth(), Window.getWinHeight());

        Renderer renderer = new Renderer();

        Updater updater = new Updater();


        window.addKeyListener(new input());
        window.add(renderer);

        window.packWindow();

        window.setVisible(true);

        boolean runGame = true;

        try {
            new Spaceship(30,650-85);
            new background(0,0);
            new landingPad(1120,650);
            new launchingPad(20,650);
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
