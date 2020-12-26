import object.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.SplittableRandom;

public class Wall extends GameObject {
    //水平或垂直
    private boolean horizontal;
    private int bricks;

    Wall(int x, int y, boolean horizontal, int bricks, Image[] image) {
        super(x, y, image);
        this.horizontal = horizontal;
        this.bricks = bricks;

    }

    @Override
    public void draw(Graphics g) {
        if (horizontal) {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(image[0], x + i * width, y, null);
            }
        } else {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(image[0], x, y + i * heihgt, null);
            }
        }
    }
}
