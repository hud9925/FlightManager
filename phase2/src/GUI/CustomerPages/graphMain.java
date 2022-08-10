package GUI.CustomerPages;
import javax.swing.*;

import static GUI.commonButtons.logout;
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

        JLabel title2 = new JLabel("Select one of the following options to continue.");
        title2.setBounds(120,40,380,25);
        panelMain.add(title2);

        JButton buyTicketButton = new JButton("Buy Tickets");
        buyTicketButton.setBounds(100, 70, 150, 25);
        panelMain.add(buyTicketButton);
        buyTicketButton.addActionListener(e -> {
            statusLabel.setText("Redirecting ... (not yet developed)");
            f.getContentPane().removeAll();
            f.repaint();
            graphBuyTicket.setBuyTicketPanel();

        });

        JButton viewTicketsButton = new JButton("View Tickets");
        viewTicketsButton.setBounds(300, 70, 150, 25);
        panelMain.add(viewTicketsButton);
        viewTicketsButton.addActionListener(e -> {
            statusLabel.setText("Redirecting ... (not yet developed)");
//            f.getContentPane().removeAll();
//            f.repaint();

        });

        JButton viewAccountButton = new JButton("Account Details");
        viewAccountButton.setBounds(100, 100, 150, 25);
        panelMain.add(viewAccountButton);
        viewAccountButton.addActionListener(e -> {
            statusLabel.setText("Redirecting ... (not yet developed)");
//            f.getContentPane().removeAll();
//            f.repaint();

        });

        JButton viewMemberButton = new JButton("Membership");
        viewMemberButton.setBounds(300, 100, 150, 25);
        panelMain.add(viewMemberButton);
        viewMemberButton.addActionListener(e -> {
            statusLabel.setText("Redirecting ... (not yet developed)");
//            f.getContentPane().removeAll();
//            f.repaint();

        });

        JButton viewPaymentButton = new JButton("Update Payments");
        viewPaymentButton.setBounds(100, 130, 150, 25);
        panelMain.add(viewPaymentButton);
        viewPaymentButton.addActionListener(e -> {
            statusLabel.setText("Redirecting ... (not yet developed)");
//            f.getContentPane().removeAll();
//            f.repaint();

        });


        logout(panelMain);

        JLabel foot1 = new JLabel("Please do not directly close the window, otherwise the data will not be saved!");
        foot1.setBounds(100,500,460,25);
        panelMain.add(foot1);

    }


}
