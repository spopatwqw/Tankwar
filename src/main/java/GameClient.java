import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {

    private int screenWidth;
    private int screenHeight;
    private boolean stop;

    //玩家坦克
    private Tank playerTank;

    //預設遊戲畫面
    GameClient(){
        this.setPreferredSize(new Dimension(800,600));
    }

    public GameClient(int screenWidth,int screenHeight){
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));

        init();

        new Thread(()->{
            while (!stop) {
                repaint();
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void init(){
        playerTank = new Tank(100, 100, Direction.DOWN);
    }

    //坦克移動
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                playerTank.setDirection(Direction.UP);
                playerTank.setY(playerTank.getY()-playerTank.getSpeed());
                break;
            case KeyEvent.VK_DOWN:
                playerTank.setDirection(Direction.DOWN);
                playerTank.setY(playerTank.getY()+playerTank.getSpeed());

                break;
            case KeyEvent.VK_LEFT:
                playerTank.setDirection(Direction.LEFT);
                playerTank.setX(playerTank.getX()-playerTank.getSpeed());

                break;
            case KeyEvent.VK_RIGHT:
                playerTank.setDirection(Direction.RIGHT);
                playerTank.setX(playerTank.getX()+playerTank.getSpeed());

                break;
            default:

        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(playerTank.getImage(),
                playerTank.getX(),playerTank.getY(),null);
    }

    public void keyReleased(KeyEvent e) {
    }
}


