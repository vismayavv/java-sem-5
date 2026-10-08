import java.applet.Applet;
import java.awt.Graphics;

public class MovingCircleApplet extends Applet implements Runnable {

    int x = 0;
    Thread animationThread;
    boolean running = false;

    public void init() {
        x = 0;
    }

    public void start() {

        if (animationThread == null) {
            running = true;
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    public void run() {

        while (running) {

            x += 5;

            if (x > getWidth()) {
                x = 0;
            }

            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Animation interrupted");
            }
        }
    }

    public void paint(Graphics g) {
        g.fillOval(x, 100, 50, 50);
    }

    public void stop() {
        running = false;
        animationThread = null;
    }
}
