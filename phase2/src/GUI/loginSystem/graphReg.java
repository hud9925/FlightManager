package GUI.loginSystem;

import GUI.CustomerPages.graphMain;
import GUI.firstPage;
import UseCases.Customer.RegisterUseCase;

import javax.swing.*;

import java.time.LocalDate;

import static GUI.graphUIMaster.f;

public class graphReg {
    private static JLabel statusLabel;
    public static void setRegPanel(){
        JPanel panel3 = new JPanel();
        f.add(panel3);
        regUI(panel3);
        f.setVisible(true);
        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 400, 500,25);
        panel3.add(statusLabel);
    }

    public static void regUI(JPanel panel3){
        panel3.setLayout(null);

        JLabel titleR1 = new JLabel("Welcome to the Air Ticket Reserving System Registration Page!");
        titleR1.setBounds(120,10,380,25);
        panel3.add(titleR1);

        JLabel titleR2 = new JLabel("Please enter your credentials below.");
        titleR2.setBounds(150,40,350,25);
        panel3.add(titleR2);


        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 60, 160, 25);
        panel3.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(210, 60, 160, 25);
        panel3.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 90, 160, 25);
        panel3.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(210, 90, 160, 25);
        panel3.add(passwordText);

        JLabel yrLabel = new JLabel("Year of Birth (YYYY)");
        yrLabel.setBounds(10, 120, 200, 25);
        panel3.add(yrLabel);

        JTextField yrText = new JTextField(20);
        yrText.setBounds(210, 120, 160, 25);
        panel3.add(yrText);

        JLabel mthLabel = new JLabel("Month of Birth (MM)");
        mthLabel.setBounds(10, 150, 200, 25);
        panel3.add(mthLabel);

        JTextField mthText = new JTextField(20);
        mthText.setBounds(210, 150, 160, 25);
        panel3.add(mthText);

        JLabel dLabel = new JLabel("Day of Birth (DD)");
        dLabel.setBounds(10, 180, 200, 25);
        panel3.add(dLabel);

        JTextField dText = new JTextField(20);
        dText.setBounds(210, 180, 160, 25);
        panel3.add(dText);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 210, 200, 25);
        panel3.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(210, 210, 160, 25);
        panel3.add(emailText);

        JButton backButton = new JButton("Back");
        backButton.setBounds(120, 280, 120, 25);
        panel3.add(backButton);
        backButton.addActionListener(e -> {
            f.getContentPane().removeAll();
            f.repaint();
            firstPage.setMainPage();
        });


        JButton registerButton = new JButton("Register");
        registerButton.setBounds(260, 280, 120, 25);
        panel3.add(registerButton);
        registerButton.addActionListener(e -> {
            String username = userText.getText();
            String password = String.valueOf(passwordText.getPassword());
            String year = yrText.getText();
            String month = mthText.getText();
            String day = dText.getText();
            String email = emailText.getText();

            // Now Assume that the year-month-day follows the format of YYYY-MM-DD
            // and is reasonable (e.g. not 1234-56-78 but 2000-01-01)

            if (!RegisterUseCase.newUser(username, password, LocalDate.parse(year + "-" + month + "-" + day),
                    email)) { //false = Username is already registered.
                statusLabel.setText("An account with this username already exists. Please try again.");
            }

            else { //true = Username is available.
                statusLabel.setText("Account created successfully! Redirecting...");
                f.getContentPane().removeAll();
                f.repaint();
                graphMain.setMainPanel();

            }
        });




    }


}
