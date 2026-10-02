import java.awt.*;
import java.awt.event.*;

public class ColorSelection extends Frame implements ActionListener {

    Button redButton;
    Button greenButton;
    Button blueButton;
    Panel panel;

    public ColorSelection() {

        setTitle("Color Selection");
        setSize(500, 300);
        setLayout(new BorderLayout());

        panel = new Panel();

        redButton = new Button("Red");
        greenButton = new Button("Green");
        blueButton = new Button("Blue");

        panel.add(redButton);
        panel.add(greenButton);
        panel.add(blueButton);

        add(panel, BorderLayout.CENTER);

        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == redButton) {
            panel.setBackground(Color.RED);
        } else if (e.getSource() == greenButton) {
            panel.setBackground(Color.GREEN);
        } else if (e.getSource() == blueButton) {
            panel.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new ColorSelection();
    }
}
