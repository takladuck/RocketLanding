package render;

import core.Window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Renderer extends JPanel {
    private static ArrayList<Renderable> rendedrableObjects = new ArrayList<>();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) Window.getWinWidth(), (int) Window.getWinHeight());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Renderable object : rendedrableObjects) {
            object.drawSprite(g2d);
        }

    }
    public static void addRendedrableObject(Renderable object) {
        rendedrableObjects.add(object);
        Collections.sort(rendedrableObjects);
    }
    public static void removeRendedrableObject(Renderable object) {
        rendedrableObjects.remove(object);
    }

}
