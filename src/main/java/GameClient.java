import javax.swing.*;
import java.awt.*;

public class GameClient extends JComponent {

    private int screenWidth;
    private int screenHeight;

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
    }

    public void init(){
        playerTank = new Tank(400, 100, Direction.UP);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(playerTank.getImage(),
                playerTank.getX(),playerTank.getY(),null);
    }
}


