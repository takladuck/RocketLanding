package core;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class startScreen extends JFrame {
    private static double winWidth = 1280;
    private static double winHeight = 720;
    private static String winName;
    public startScreen(String winName, double winWidth, double winHeight) {
        super (winName);
        startScreen.winName = winName;
        startScreen.winWidth = winWidth;
        startScreen.winHeight = winHeight;
        setWindowAttributes();
    }
    public void packWindow(){
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void setWindowAttributes(){
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static double getWinWidth(){
        return winWidth;
    }
    public static double getWinHeight(){
        return winHeight;
    }
    public static String getWinName(){
        return winName;
    }
}


/*public class startScreen {
    private boolean startPressed;
    public void StartScreen() {
        startPressed = false;
    }

    public void display(Graphics g) {
        // Render the start screen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int) Window.getWinWidth(), (int) Window.getWinHeight());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Spaceship Game", 450, 300);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Click to Start", 530, 400);
    }

    public void checkStart(MouseEvent e) {
        startPressed = true;
    }

    public boolean isStartPressed() {
        return startPressed;
    }
}*/
