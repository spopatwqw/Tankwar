import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {

    private int x;
    private int y;
    private int speed;
    //上下左右四個方向
    private boolean[] dirs = new boolean[4];

    private Direction direction;


    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        //坦克速度
        speed = 5;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Image getImage() {
        if (direction == Direction.UP)
            return new ImageIcon("assets/images/itankU.png").getImage();
        if (direction == Direction.DOWN)
            return new ImageIcon("assets/images/itankD.png").getImage();
        if (direction == Direction.LEFT)
            return new ImageIcon("assets/images/itankL.png").getImage();
        if (direction == Direction.RIGHT)
            return new ImageIcon("assets/images/itankR.png").getImage();
        if (direction == Direction.UP_RIGHT)
            return new ImageIcon("assets/images/itankRU.png").getImage();
        if (direction == Direction.UP_LEFT)
            return new ImageIcon("assets/images/itankLU.png").getImage();
        if (direction == Direction.DOWN_RIGHT)
            return new ImageIcon("assets/images/itankRD.png").getImage();
        if (direction == Direction.DOWN_LEFT)
            return new ImageIcon("assets/images/itankLD.png").getImage();


        return null;


    }

    public int getSpeed() {
        return speed;
    }

    //新增坦克移動方法
    public void move() {
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }


    public boolean[] getDirs() {
        return dirs;
    }

    //新增偵測方向(避免上下一起按)
    private void determineDirection() {
        //上下左右
        if (dirs[0] &&dirs[2]&&dirs[1]&&dirs[3]) direction= Direction.UP_LEFT;
    }
}
