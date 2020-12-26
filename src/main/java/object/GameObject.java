package object;

import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected int width;
    protected int heihgt;

    protected Image[] image;

    public GameObject(int x, int y, Image[] image) {
        this.x = x;
        this.y = y;
        this.image = image;
        width=image[0].getWidth(null);
        heihgt=image[0].getHeight(null);
    }

    protected abstract void draw(Graphics g);
}
