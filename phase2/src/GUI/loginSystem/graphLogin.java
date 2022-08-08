package GUI.loginSystem;

import GUI.AdminPages.graphAdmin;
import GUI.CustomerPages.graphMain;
import GUI.firstPage;
import Presenters.Admin.AdminMenu;
import Presenters.Customer.LoginMenu;
import Presenters.Customer.MainMenu;
import UseCases.Customer.LoginUseCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static GUI.graphUIMaster.f;
import static Presenters.Customer.LoginMenu.getCred;

public class graphLogin {
    private static JLabel statusLabel;
    public static void setLoginPanel(){
        JPanel panel2 = new JPanel();
        f.add(panel2);
        loginUI(panel2);
        f.setVisible(true);
        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 200, 500,25);
        panel2.add(statusLabel);
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


        JButton backButton = new JButton("Back");
        backButton.setBounds(120, 120, 120, 25);
        panel2.add(backButton);
        backButton.addActionListener(e -> {
            f.getContentPane().removeAll();
            f.repaint();
            firstPage.setMainPage();
        });

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(260, 120, 120, 25);
        panel2.add(loginButton);
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = String.valueOf(passwordText.getPassword());
            ArrayList<Boolean> credPredicates = getCred(username, password);
            if (!credPredicates.get(0)){
                statusLabel.setText("Error: either your username or password is incorrect. Please try again.");
            }
          else {
                statusLabel.setText("Success. Redirecting to admin page...");
                f.getContentPane().removeAll();
                f.repaint();
                graphAdmin.setAdminPanel();
                if (!credPredicates.get(1)){
                    statusLabel.setText("Success. Redirecting to main page...");
                    f.getContentPane().removeAll();
                    f.repaint();
                    graphMain.setMainPanel();
                }
            }
        });

    }
}
