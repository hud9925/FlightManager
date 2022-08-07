package GUI;
import javax.swing.*;

import static GUI.graphUIMaster.f;

public class graphAdmin {
    private static JLabel statusLabel;

    public static void setAdminPanel(){
        JPanel panelAdmin = new JPanel();
        f.add(panelAdmin);
        mainPanelUI(panelAdmin);
        f.setVisible(true);
        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 400, 500,25);
        panelAdmin.add(statusLabel);
    }
    public static void mainPanelUI(JPanel panelAdmin){
        panelAdmin.setLayout(null);

        JLabel title1 = new JLabel("Welcome to the Air Ticket Reserving System Admin Page!");
        title1.setBounds(120,10,380,25);
        panelAdmin.add(title1);

    }

}
