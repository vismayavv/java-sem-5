import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseApplet extends Applet implements MouseListener {

    String message = "Move the mouse inside the applet";
    int x = 0;
    int y = 0;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 50);

        if (x != 0 || y != 0) {
            g.drawString("Mouse clicked at: (" + x + ", " + y + ")", 50, 80);
        }
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        message = "Mouse clicked!";
        repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
      
