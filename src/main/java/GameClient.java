

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {

    private int screenWidth;
    private int screenHeight;

    private Tank playerTank;


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
                while(true){
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

    public void init(){
        playerTank=new Tank(400,300, Direction.DOWN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,screenWidth,screenHeight);

        playerTank.draw(g);
    }

    public void keyPressed(KeyEvent e){
        //傳址
        boolean[] dirs= playerTank.getDirs();

        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                dirs[0]=true;

                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=true;
                break;

            case KeyEvent.VK_LEFT:
                dirs[2]=true;
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3]=true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        //傳址
        boolean[] dirs= playerTank.getDirs();

        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                dirs[0]=false;

                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=false;
                break;

            case KeyEvent.VK_LEFT:
                dirs[2]=false;
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3]=false;
                break;
        }
    }
}
