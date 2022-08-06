package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.graphUIMain.f;

public class firstPage {
    public static void mainPage(JPanel panel1) {

        panel1.setLayout(null);

        JLabel title = new JLabel("Welcome to the Air Ticket Reserving System!");
        title.setBounds(150,10,350,25);
        panel1.add(title);

        JButton newUserButton = new JButton("New User");
        newUserButton.setBounds(100, 40, 150, 25);
        panel1.add(newUserButton);
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.repaint();
                graphReg.setRegPanel();
            }
        });


        JButton existingUserButton = new JButton("Existing User");
        existingUserButton.setBounds(280,40,150,25);
        panel1.add(existingUserButton);
        existingUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.repaint();
                graphLogin.setLoginPanel();
            }
        });



    }
}
