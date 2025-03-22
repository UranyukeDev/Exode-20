package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenu extends JComponent {
    private static final String[] options = {"Start Game", "Options", "Exit"};
    private int selectedIndex = 0;
    private Game game;
    private boolean showCursor = true;

    public MainMenu(Game game) {
        this.game = game;
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        
        // Keyboard
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        moveDown();
                        break;
                    case KeyEvent.VK_ENTER:
                        selectOption();
                        break;
                }
            }
        });

        Timer cursorBlink = new Timer(500, e -> {
            showCursor = !showCursor;
            repaint();
        });
        cursorBlink.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderMenu(g);
    }

    private void renderMenu(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 28));

        drawAsciiTitle(g, 100);

        for (int i = 0; i < options.length; i++) {
            if (i == selectedIndex) {
                g.setColor(Color.YELLOW);
                if (showCursor) {
                    g.drawString("> " + options[i] + " <", 300, 250 + (i * 40));
                } else {
                    g.drawString("  " + options[i] + "  ", 300, 250 + (i * 40));
                }
            } else {
                g.setColor(Color.WHITE);
                g.drawString("  " + options[i], 300, 250 + (i * 40));
            }
        }
    }

    private void drawAsciiTitle(Graphics g, int y) {
        String[] title = {
            " _____ __ __ _____ ____  _____    ___ ___ ",
            "|   __|  |  |     |    \\|   __|  |_  |   |",
            "|   __|-   -|  |  |  |  |   __|  |  _| | |",
            "|_____|__|__|_____|____/|_____|  |___|___|"
        };

        g.setFont(new Font("Courier New", Font.BOLD, 24));
        for (int i = 0; i < title.length; i++) {
            g.drawString(title[i], 180, y + (i * 30));
        }
    }

    private void moveUp() {
        if (selectedIndex > 0) {
            selectedIndex--;
        }
        repaint();
    }

    private void moveDown() {
        if (selectedIndex < options.length - 1) {
            selectedIndex++;
        }
        repaint();
    }

    private void selectOption() {
        switch (options[selectedIndex]) {
            case "Start Game":
                game.changeScene(Scenes.INTRODUCTION);
                break;
            case "Options":
                System.out.println("Opening options.");
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }
}