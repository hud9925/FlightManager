package GUI;
import javax.swing.*;

import static GUI.graphUIMaster.f;

public class graphMain {
    private static JLabel statusLabel;

    public static void setMainPanel(){
        JPanel panelMain = new JPanel();
        f.add(panelMain);
        mainPanelUI(panelMain);
        f.setVisible(true);
        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 400, 500,25);
        panelMain.add(statusLabel);
    }
    public static void mainPanelUI(JPanel panelMain){
        panelMain.setLayout(null);

        JLabel title1 = new JLabel("Welcome to the Air Ticket Reserving System Main Page!");
        title1.setBounds(120,10,380,25);
        panelMain.add(title1);

    }
}
