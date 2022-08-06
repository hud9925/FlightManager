package GUI;
import javax.swing.*;

import java.awt.FlowLayout;

public class graphUI {

    public static void main(String[] args) {
            // Create and set up a frame window

            JFrame frame = new JFrame("Air Ticket Reserving System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            // Define new buttons
        JLabel label = new JLabel("Welcome to the Air Ticket Reserving System...\n");
        label.setBounds(50, 50, 100, 30);
            JButton jb1 = new JButton("New User");
            JButton jb2 = new JButton("Existing User");



            // Define the panel to hold the buttons
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(jb1);
            panel.add(jb2);
            panel.add(label);
        frame.setSize(500,300);

            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        }

}
