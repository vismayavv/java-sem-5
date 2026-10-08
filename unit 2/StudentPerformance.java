import java.awt.*;
import java.awt.event.*;

public class StudentPerformance extends Frame
        implements ActionListener {

    TextField nameField;
    TextField mark1Field;
    TextField mark2Field;
    TextField mark3Field;

    Button calculateButton;
    Label resultLabel;

    public StudentPerformance() {

        setTitle("Student Performance Management");
        setSize(500, 400);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new Label("Student Name:"));
        nameField = new TextField();
        add(nameField);

        add(new Label("Mark 1:"));
        mark1Field = new TextField();
        add(mark1Field);

        add(new Label("Mark 2:"));
        mark2Field = new TextField();
        add(mark2Field);

        add(new Label("Mark 3:"));
        mark3Field = new TextField();
        add(mark3Field);

        calculateButton = new Button("Calculate");
        add(calculateButton);

        resultLabel = new Label("Result will appear here.");
        add(resultLabel);

        calculateButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            double m1 = Double.parseDouble(mark1Field.getText());
            double m2 = Double.parseDouble(mark2Field.getText());
            double m3 = Double.parseDouble(mark3Field.getText());

            if (m1 < 0 || m1 > 100 ||
                m2 < 0 || m2 > 100 ||
                m3 < 0 || m3 > 100) {

                resultLabel.setText("Marks must be 0-100");
                return;
            }

            double total = m1 + m2 + m3;
            double average = total / 3;

            resultLabel.setText(
                    "Total: " + total +
                    " Average: " + String.format("%.2f", average)
            );

        } catch (NumberFormatException ex) {
            resultLabel.setText("Enter valid marks");
        }
    }

    public static void main(String[] args) {
        new StudentPerformance();
    }
}
