package game;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;

public class Game {
    private boolean gameRunning;
    private Scenes currentScene;
    private JFrame gameWindow;
    private JComponent currentComponent;

    Game(){
        this.gameRunning = true;
        this.currentScene = Scenes.MAINMENU;
    }

    public void setupWindow(){
        gameWindow = new JFrame("Exode20");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(1280, 720);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.getContentPane().setBackground(Color.BLACK);

        MainMenu mainMenu = new MainMenu(this);
        gameWindow.add(mainMenu);
        gameWindow.setVisible(true);
    }

    public boolean isGameRunning(){
        return gameRunning;
    }

    public Scenes getCurrentScene() {
        return currentScene;
    }

    public void changeScene(Scenes scene) {
        this.currentScene = scene;
        gameWindow.remove(currentComponent);

        switch (scene) {
            case MAINMENU:
                currentComponent = new MainMenu(this);
                break;
            case INTRODUCTION:
                //currentComponent = new IntroductionScene(this);
                break;
            case GAMEOVER:
                //currentComponent = new GameOverScene(this);
                break;
        }

        gameWindow.add(currentComponent);
        gameWindow.revalidate();
        gameWindow.repaint();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setupWindow();

        while (game.isGameRunning()) {
            if (game.getCurrentScene() == Scenes.MAINMENU) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}