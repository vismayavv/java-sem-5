import java.awt.*;
import java.awt.event.*;

public class MouseKeyboardDemo extends Frame {

    Label label;

    public MouseKeyboardDemo() {

        setTitle("Mouse and Keyboard Events");
        setSize(500, 300);
        setLayout(new BorderLayout());

        label = new Label("Move mouse or press a key.");
        add(label, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                label.setText(
                        "Mouse clicked at X = "
                        + e.getX()
                        + ", Y = "
                        + e.getY()
                );
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e) {
                label.setText(
                        "Mouse Position: X = "
                        + e.getX()
                        + ", Y = "
                        + e.getY()
                );
            }
        });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                label.setText(
                        "Key Pressed: "
                        + e.getKeyChar()
                );
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setFocusable(true);
        setVisible(true);
        requestFocus();
    }

    public static void main(String[] args) {
        new MouseKeyboardDemo();
    }
}
