package Gateways;

import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.User.*;
import Entities.User.Ticket.Ticket;
import UseCases.Admin.GetUser;
import UseCases.Customer.SeatViewer;
import UseCases.Customer.ShowFlight;
import UseCases.FlightNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentConnector extends DatabaseConnector{

    public PaymentConnector() throws IOException {
        super();
    }

    @Override
    protected String getDatabaseName() {
        return "PaymentBase.csv";
    }

    @Override
    public void save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        for(User user: UserTracker.getInstance()){
            if(user instanceof Customer){
                pw.write(((Customer) user).getPaymentMethod().toString() + "\n");
            }
        }
        pw.close();
    }

    @Override
    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            PaymentMethod pm = lineToPayment(line);
            Customer user = (Customer) GetUser.returnUser(pm.getOwner());
            user.setPaymentMethod(pm);
        }
        br.close();
    }
    private PaymentMethod lineToPayment(String line){
        String[] PaymentData = line.split(",");
        PaymentMethod pm = new PaymentMethod(PaymentData[0], Integer.parseInt(PaymentData[1]),
                Integer.parseInt(PaymentData[2]));
        pm.setBalance(Integer.parseInt(PaymentData[3]));
        return pm;
    }
}
