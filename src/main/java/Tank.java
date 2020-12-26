
import object.GameObject;

import javax.swing.*;
import java.awt.*;

public class Tank extends GameObject {

    private boolean enemy;
    private int speed;
    private Direction direction;
    //0:上 1:下 2:左 3:右四個方向
    private boolean[] dirs = new boolean[4];


    public Tank(int x, int y, Direction direction, Image[] image) {
        this(x, y, direction, false, image);
    }

    public Tank(int x, int y, Direction direction, boolean enemy, Image[] image) {
        super(x, y, image);
        this.direction = direction;
        speed = 5;
        this.enemy = enemy;
    }


    public boolean[] getDirs() {
        return dirs;
    }

    public void detectDirection() {
        if (dirs[0] && !dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.UP;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.DOWN;
        } else if (!dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT;
        } else if (!dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT;
        } else if (dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT_UP;
        } else if (dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT_UP;
        } else if (!dirs[0] && dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT_DOWN;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT_DOWN;
        }
    }

    public int getSpeed() {
        return speed;
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

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    //坦克圖片
    public Image getImage() {

        String name = enemy ? "etank" : "itank";
        ;


        if (direction == Direction.UP) {
            return new ImageIcon("assets/images/" + name + "U.png").getImage();
        }

        if (direction == Direction.DOWN) {
            return new ImageIcon("assets/images/" + name + "D.png").getImage();
        }

        if (direction == Direction.LEFT) {
            return new ImageIcon("assets/images/" + name + "L.png").getImage();
        }

        if (direction == Direction.RIGHT) {
            return new ImageIcon("assets/images/" + name + "R.png").getImage();
        }

        if (direction == Direction.LEFT_DOWN) {
            return new ImageIcon("assets/images/" + name + "LD.png").getImage();
        }

        if (direction == Direction.RIGHT_DOWN) {
            return new ImageIcon("assets/images/" + name + "RD.png").getImage();
        }

        if (direction == Direction.LEFT_UP) {
            return new ImageIcon("assets/images/" + name + "LU.png").getImage();
        }

        if (direction == Direction.RIGHT_UP) {
            return new ImageIcon("assets/images/" + name + "RU.png").getImage();
        }

        return null;
    }

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
            case LEFT_UP:
                x -= speed;
                y -= speed;
                break;
            case LEFT_DOWN:
                x -= speed;
                y += speed;
                break;
            case RIGHT_DOWN:
                x += speed;
                y += speed;
                break;
            case RIGHT_UP:
                x += speed;
                y -= speed;
                break;
        }
    }

    //繪製
    public void draw(Graphics g) {
        if (isKeyPressed()) {
            detectDirection();
            move();
        }

        g.drawImage(image[direction.ordinal()],x,y,null);

    }

    //按鍵偵測
    public boolean isKeyPressed() {

        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i]) {
                return true;
            }
        }

        return false;
    }


    //坦克停止
    public boolean isStop() {
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i]) {
                return false;
            }
        }

        return true;
    }
}
