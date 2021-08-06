import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GraphicsDemo extends JPanel implements ActionListener {

    Random random = new Random();
    Timer timer = new Timer(1, this);
    JLabel label;
    int x = 1;
    int y = 1;
    int velocityX = 1;
    int velocityY = 1;
    int randomX = 0;
    int randomY = 0;

    public GraphicsDemo(){

        label = new JLabel((new ImageIcon("Untitled.png")));
        label.setSize(300, 350);
        label.setLocation(500, 500);
        this.setLayout(null);
        this.add(label);
        timer.start();
    }

    public  void paintComponent(Graphics g){

        super.paintComponent(g);
        this.setBackground(new Color(50, 255, 255));

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.YELLOW);
        g2D.fillOval(x, 0, 100, 100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x >= 840 || x <= 0){
            velocityX = - velocityX;
        }
        if(y >= 740 || y <= 0){
            velocityY = velocityY;
        }

        randomX = random.nextInt(51)-25;
        randomY = random.nextInt(51)-25;

        x = x + randomX;
        y = y + randomY;
//        x = x + velocityX;
//        y = y + velocityY;
        repaint();
        label.setLocation(x,y);

    }
}
