package Gateways;

import Entities.User.*;
import UseCases.Admin.GetUser;

import java.io.*;

/**
 * Connector class for user payment methods, extends database connector
 */
public class PaymentConnector extends DatabaseConnector{

    public PaymentConnector() throws IOException {
        super();
    }

    /**
     * Gets the database's name (filepath)
     */
    @Override
    protected String getDatabaseName() {
        return "PaymentBase.csv";
    }

    /**
     * Save method for every user in user tracker's payment method
     */
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

    /**
     * Loading method that reads the payment method data from the database
     */
    @Override
    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            PaymentMethod pm = lineToPayment(line);
            Customer user = (Customer) GetUser.returnUser(pm.getOwner());
            if(user != null){
                user.setPaymentMethod(pm);
            }
        }
        br.close();
    }

    /**
     * Helper that translates a line of string data into a payment method for a user
     * @param line the line of data
     * @return the payment method
     */
    private PaymentMethod lineToPayment(String line){
        String[] PaymentData = line.split(",");
        PaymentMethod pm = new PaymentMethod(PaymentData[0], Long.parseLong(PaymentData[1]),
                PaymentData[2]);
        pm.setBalance(Integer.parseInt(PaymentData[3]));
        return pm;
    }
}
