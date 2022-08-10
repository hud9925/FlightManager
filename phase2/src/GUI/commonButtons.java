package GUI;

import javax.swing.*;

import static GUI.graphUIMaster.f;

public class commonButtons {
    /**
     * This class contains some common buttons in both Admin and Main (normal customer) GUI pages.
     */
    public static void logout(JPanel somePanel) {
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(220, 160, 150, 25);
        somePanel.add(logoutButton);
        logoutButton.addActionListener(e -> {
            f.getContentPane().removeAll();
            f.repaint();
            firstPage.setMainPage();
        });
    }

}
