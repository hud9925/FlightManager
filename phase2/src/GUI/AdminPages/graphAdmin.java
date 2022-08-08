package GUI.AdminPages;
import GUI.commonButtons;

import javax.swing.*;

import static GUI.graphUIMaster.f;

public class graphAdmin {
    private static JLabel statusLabel;

    public static void setAdminPanel(){
        JPanel panelAdmin = new JPanel();
        f.add(panelAdmin);
        adminPanelUI(panelAdmin);
        f.setVisible(true);
        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 400, 500,25);
        panelAdmin.add(statusLabel);
    }
    public static void adminPanelUI(JPanel panelAdmin){
        panelAdmin.setLayout(null);

        JLabel title1 = new JLabel("Welcome to the Air Ticket Reserving System Admin Page!");
        title1.setBounds(120,10,380,25);
        panelAdmin.add(title1);

        JLabel title2 = new JLabel("Select one of the following options to continue.");
        title2.setBounds(120,40,380,25);
        panelAdmin.add(title2);

        JButton usersButton = new JButton("View all users");
        usersButton.setBounds(100, 70, 150, 25);
        panelAdmin.add(usersButton);
        usersButton.addActionListener(e -> {
            statusLabel.setText("Redirecting to the user list page... (not yet developed)");
//            f.getContentPane().removeAll();
//            f.repaint();

        });

        JButton flightsButton = new JButton("View the flights");
        flightsButton.setBounds(300, 70, 150, 25);
        panelAdmin.add(flightsButton);
        flightsButton.addActionListener(e -> {
            statusLabel.setText("Redirecting to the flight list page... (not yet developed)");
//            f.getContentPane().removeAll();
//            f.repaint();

        });

        commonButtons.logout(panelAdmin);

        JLabel foot1 = new JLabel("Please do not directly close the window, otherwise the data will not be saved!");
        foot1.setBounds(100,500,460,25);
        panelAdmin.add(foot1);

    }
}
