import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ParameterApplet extends Applet {

    String message;
    Color backgroundColor;
    Color foregroundColor;

    public void init() {

        message = getParameter("message");

        String bg = getParameter("background");
        String fg = getParameter("foreground");

        backgroundColor = Color.decode(bg);
        foregroundColor = Color.decode(fg);

        setBackground(backgroundColor);
        setForeground(foregroundColor);
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 100);
    }
}
