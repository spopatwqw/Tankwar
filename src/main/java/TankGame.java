import javax.swing.*;

public class TankGame {
    public static void main(String[] args) {

        JFrame frame=new JFrame();
        GameClient gameClient=new GameClient(800,600);
        frame.setTitle("坦克大戰!");
        frame.setResizable(false);
        frame.add(gameClient);
        frame.pack();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        gameClient.repaint();
    }
}
