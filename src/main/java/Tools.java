import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Tools {
    public static Image getImage(String fileName){
        return new ImageIcon("assets/images/"+fileName).getImage();
    }
}
