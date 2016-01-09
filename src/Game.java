import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

/**
 * Created by YB on 08.01.2016.
 */
public class Game extends JFrame {

    private RedBall target;

    Game () {
        super("Angry friend");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(500, 100);
        setResizable(false);
        target = new RedBall(100, 100);
        this.getContentPane().add(target);
    }
}

class RedBall extends JComponent implements MouseMotionListener {

    private Ellipse2D redBall;
    private double x;
    private double y;

    RedBall(int x, int y) {
        this.x = x;
        this.y = y;
        redBall = new Ellipse2D.Double(x, y, 70, 70);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fill(redBall);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (redBall.contains(e.getX(), e.getY())) {
            x = (Math.random() * 530);
            y = (Math.random() * 530);
            redBall = new Ellipse2D.Double(x, y, 70, 70);
            repaint();
        }
    }
}


