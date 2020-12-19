import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {

    private int screenWidth;
    private int screenHeight;
    private boolean stop;
    //上下左右四個方向
    private boolean[] dirs = new boolean[4];


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
        boolean[] dirs=playerTank.getDirs();
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
            default:

        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(playerTank.getImage(),
                playerTank.getX(),playerTank.getY(),null);
    }

    //方向左上下,右上下
    public void keyReleased(KeyEvent e) {
        boolean[] dirs=playerTank.getDirs();
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
            default:

        }

        repaint();
    }
}


