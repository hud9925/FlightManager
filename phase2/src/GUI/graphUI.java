package GUI;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class graphUI {


    public static void main(String[] args) {
        JFrame f = new JFrame("Air Ticket Reserving System");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        f.add(panel1);
        firstPage(panel1);

        f.setVisible(true);
    }

    private static void firstPage(JPanel panel1) {

        panel1.setLayout(null);

        JLabel title = new JLabel("Welcome to the Air Ticket Reserving System!");
        title.setBounds(150,10,350,25);
        panel1.add(title);

        JButton newUserButton = new JButton("New User");
        newUserButton.setBounds(100, 40, 150, 25);
        panel1.add(newUserButton);

        JButton existingUserButton = new JButton("Existing User");
        existingUserButton.setBounds(280,40,150,25);
        panel1.add(existingUserButton);


//        Reserved for login
//        JLabel userLabel = new JLabel("User");
//        userLabel.setBounds();
//        panel1.add(userLabel);
//
//        JTextField userText = new JTextField(20);
//        userText.setBounds();
//        panel1.add(userText);
//
//        JLabel passwordLabel = new JLabel("Password");
//        passwordLabel.setBounds();
//        panel1.add(passwordLabel);
//
//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds();
//        panel1.add(passwordText);
//
    }
}