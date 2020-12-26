

import jdk.internal.icu.text.UnicodeSet;
import object.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class GameClient extends JComponent {

    private int screenWidth;
    private int screenHeight;
    private ArrayList<GameObject> gameObjects = new ArrayList<>();



    //玩家坦克
    private Tank playerTank;
    //敵方坦克
    private ArrayList<Tank> enemyTanks = new ArrayList<>();
    //牆面
    private ArrayList<Wall> walls = new ArrayList<>();


    GameClient() {
        this(800, 600);
    }

    public GameClient(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //更新遊戲畫面
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void init() {

        Image[] brickImage = {Tools.getImage("brick.png")};
        Image[] iTankImage = new Image[8];
        Image[] eTankImage = new Image[8];

        String[] sub = {"U.png", "D.png", "L.png", "R.png", "LU.png", "RU.png", "LD.png", "RD.png"};

        for (int i = 0; i < iTankImage.length; i++) {
            iTankImage[i] = Tools.getImage("itank" + sub[i]);
            eTankImage[i] = Tools.getImage("etank" + sub[i]);
        }

        playerTank = new Tank(500, 100, Direction.DOWN, iTankImage);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                enemyTanks.add(new Tank(350 + j * 100, 500 + 80 * i, Direction.UP, eTankImage));
            }
        }


        //牆面
        Wall[] walls = {
                new Wall(250, 150, true, 15, brickImage),
                new Wall(150, 200, false, 15, brickImage),
                new Wall(800, 200, false, 15, brickImage),
        };

        this.walls.addAll(Arrays.asList(walls));



    }

    @Override
    public void paintComponent(Graphics g) {
        playerTank.draw(g);
        for (Tank tank : enemyTanks) {
            tank.draw(g);
        }

        for (Wall wall : walls) {
            wall.draw(g);
        }


    }

    public void keyPressed(KeyEvent e) {
        //傳址
        boolean[] dirs = playerTank.getDirs();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = true;

                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = true;
                break;

            case KeyEvent.VK_LEFT:
                dirs[2] = true;
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        //傳址
        boolean[] dirs = playerTank.getDirs();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = false;

                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = false;
                break;

            case KeyEvent.VK_LEFT:
                dirs[2] = false;
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3] = false;
                break;
        }
    }

}
