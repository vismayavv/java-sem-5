import java.awt.*;
import java.awt.event.*;

public class AWTCalculator extends Frame implements ActionListener {

    TextField num1;
    TextField num2;
    TextField result;

    Button add;
    Button subtract;
    Button multiply;
    Button divide;

    public AWTCalculator() {

        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new Label("First Number:"));
        num1 = new TextField();
        add(num1);

        add(new Label("Second Number:"));
        num2 = new TextField();
        add(num2);

        add(new Label("Result:"));
        result = new TextField();
        result.setEditable(false);
        add(result);

        add = new Button("Add");
        subtract = new Button("Subtract");
        multiply = new Button("Multiply");
        divide = new Button("Divide");

        add(add);
        add(subtract);
        add(multiply);
        add(divide);

        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double answer = 0;

            if (e.getSource() == add) {
                answer = a + b;
            } else if (e.getSource() == subtract) {
                answer = a - b;
            } else if (e.getSource() == multiply) {
                answer = a * b;
            } else if (e.getSource() == divide) {

                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }

                answer = a / b;
            }

            result.setText(String.valueOf(answer));

        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new AWTCalculator();
    }
}
