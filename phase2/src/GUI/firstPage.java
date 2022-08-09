package GUI;

import GUI.loginSystem.graphLogin;
import GUI.loginSystem.graphReg;

import javax.swing.*;

import static GUI.graphUIMaster.f;

public class firstPage {

    public static void setMainPage(){
        JPanel panel1 = new JPanel();
        f.add(panel1);
        firstPage.mainPage(panel1);
        f.setVisible(true);
    }
    public static void mainPage(JPanel panel1) {

        panel1.setLayout(null);

        JLabel title = new JLabel("Welcome to the Air Ticket Reserving System!");
        title.setBounds(150,10,350,25);
        panel1.add(title);

        JButton newUserButton = new JButton("New User");
        newUserButton.setBounds(100, 40, 150, 25);
        panel1.add(newUserButton);
        newUserButton.addActionListener(e -> {
            f.getContentPane().removeAll();
            f.repaint();
            graphReg.setRegPanel();
        });


        JButton existingUserButton = new JButton("Existing User");
        existingUserButton.setBounds(280,40,150,25);
        panel1.add(existingUserButton);
        existingUserButton.addActionListener(e -> {
            f.getContentPane().removeAll();
            f.repaint();
            graphLogin.setLoginPanel();
        });

        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(220,80,120,25);
        panel1.add(quitButton);
        quitButton.addActionListener(e -> f.dispose());

        JLabel foot1 = new JLabel("Please do not directly close the window, otherwise the data will not be saved!");
        foot1.setBounds(100,130,460,25);
        panel1.add(foot1);

        JLabel foot2 = new JLabel("To close the program, click 'Quit' button.");
        foot2.setBounds(100,160,350,25);
        panel1.add(foot2);

    }
}
