package GUI.CustomerPages;
import static GUI.graphUIMaster.f;
import javax.swing.*;

public class graphBuyTicket {
    private static JLabel statusLabel;

    private boolean isAdmin = false;

    public static void setBuyTicketPanel(){
        JPanel panelBuyTickets = new JPanel();
        f.add(panelBuyTickets);
        buyTicketUI(panelBuyTickets);
        f.setVisible(true);
        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 400, 500,25);
        panelBuyTickets.add(statusLabel);
    }

    private static void buyTicketUI(JPanel panelBuyTickets) {
        panelBuyTickets.setLayout(null);

        JLabel title1 = new JLabel("You reached: Customer Main Page > Buy Ticket Page");
        title1.setBounds(120,10,380,25);
        panelBuyTickets.add(title1);

        JLabel title2 = new JLabel("Below is the all available flights for ticket booking.");
        title2.setBounds(120,40,380,25);
        panelBuyTickets.add(title2);


        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 500, 150, 25);
        panelBuyTickets.add(backButton);
        backButton.addActionListener(e -> {
            f.getContentPane().removeAll();
            f.repaint();
            graphMain.setMainPanel();
        });


    }
}
