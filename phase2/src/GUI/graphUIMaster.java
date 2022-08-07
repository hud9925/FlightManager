package GUI;
import Gateways.*;
import UseCases.Admin.AddAdmin;
import UseCases.Admin.AddFlight;

import javax.swing.JFrame;
import java.io.IOException;
import java.text.ParseException;

public class graphUIMaster {

    public static JFrame f;

    public static void setF(){
        f = new JFrame("Air Ticket Reserving System");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException, ParseException {
        DatabaseConnector dc1 = new UserTrackerConnector();
        DatabaseConnector dc2 = new FlightTrackerConnector();
        DatabaseConnector dc3 = new TicketConnector();
        DatabaseConnector dc4 = new PaymentConnector();
        if (dc1.checkEmpty()){ // Check if file is empty. If empty then create first admin.
            AddAdmin.addFirstAdmin();
            dc1.save();
        }
        if (dc2.checkEmpty()){
            AddFlight.addFirstFlight();
            dc2.save();
        }
        dc1.load();
        dc2.load();
        dc3.load();
        dc4.load();

        setF();
        firstPage.setMainPage();

        dc1.save();
        dc2.save();
        dc3.save();
        dc4.save();
    }



}