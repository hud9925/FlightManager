package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.graphUIMain.f;

public class graphLogin {

    public static void setLoginPanel(){
        JPanel panel2 = new JPanel();
        f.add(panel2);
        loginUI(panel2);
        f.setVisible(true);
    }



    public static void loginUI(JPanel panel2){

        panel2.setLayout(null);

        JLabel title1 = new JLabel("Welcome to the Air Ticket Reserving System!");
        title1.setBounds(150,10,350,25);
        panel2.add(title1);

        JLabel title2 = new JLabel("Please enter your credentials below.");
        title2.setBounds(150,40,350,25);
        panel2.add(title2);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 60, 80, 25);
        panel2.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 60, 160, 25);
        panel2.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 90, 80, 25);
        panel2.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 90, 160, 25);
        panel2.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(240, 120, 120, 25);
        panel2.add(loginButton);
        loginButton.addActionListener(e -> {
            // TODO: implement me!
        });

    }
}
