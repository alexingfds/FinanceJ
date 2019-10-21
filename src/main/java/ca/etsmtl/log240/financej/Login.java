package ca.etsmtl.log240.financej;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Login extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton Connect, cancel;

    Login() {

        // User Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField(15);

        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField(15);

        // Submit

        Connect = new JButton("Connect");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(Connect);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        Connect.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(400, 300);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            FinanceJ Fj = new FinanceJ();
            Fj.setVisible(true);
            this.hide();


        } else {
            message.setText(" login ou mot de passe erroné.. ");
        }

    }


    }

