import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarkList extends JFrame
        implements ActionListener {

    JTextField nameField;
    JTextField regField;
    JTextField mark1Field;
    JTextField mark2Field;
    JTextField mark3Field;

    JTextArea resultArea;

    JButton calculateButton;
    JButton clearButton;
    JButton exitButton;

    public StudentMarkList() {

        setTitle("Student Mark List");
        setSize(500, 500);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Register Number:"));
        regField = new JTextField();
        add(regField);

        add(new JLabel("Mark 1:"));
        mark1Field = new JTextField();
        add(mark1Field);

        add(new JLabel("Mark 2:"));
        mark2Field = new JTextField();
        add(mark2Field);

        add(new JLabel("Mark 3:"));
        mark3Field = new JTextField();
        add(mark3Field);

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        add(calculateButton);
        add(clearButton);

        add(exitButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(new JScrollPane(resultArea));

        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {

            try {

                double m1 = Double.parseDouble(mark1Field.getText());
                double m2 = Double.parseDouble(mark2Field.getText());
                double m3 = Double.parseDouble(mark3Field.getText());

                if (m1 < 0 || m1 > 100 ||
                    m2 < 0 || m2 > 100 ||
                    m3 < 0 || m3 > 100) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Marks must be between 0 and 100."
                    );
                    return;
                }

                double total = m1 + m2 + m3;
                double average = total / 3;

                String grade;

                if (average >= 90)
                    grade = "A+";
                else if (average >= 80)
                    grade = "A";
                else if (average >= 70)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else if (average >= 50)
                    grade = "D";
                else
                    grade = "F";

                resultArea.setText(
                        "Student Name: " + nameField.getText()
                        + "\nRegister Number: " + regField.getText()
                        + "\nTotal: " + total
                        + "\nAverage: " + String.format("%.2f", average)
                        + "\nGrade: " + grade
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid marks."
                );
            }

        } else if (e.getSource() == clearButton) {

            nameField.setText("");
            regField.setText("");
            mark1Field.setText("");
            mark2Field.setText("");
            mark3Field.setText("");
            resultArea.setText("");

        } else if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new StudentMarkList();
    }
                    }k
