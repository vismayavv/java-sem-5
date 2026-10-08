import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame
        implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;

    JButton loginButton;
    JButton resetButton;
    JButton exitButton;

    public LoginForm() {

        setTitle("Login Form");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        add(loginButton);
        add(resetButton);
        add(exitButton);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") &&
                password.equals("1234")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid username or password.",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } else if (e.getSource() == resetButton) {

            usernameField.setText("");
            passwordField.setText("");

        } else if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
        }
