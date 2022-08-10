import Gateways.*;
import Presenters.Customer.LoginMenu;
import UseCases.Admin.AddAdmin;
import UseCases.Admin.AddFlight;

import java.io.IOException;
import java.text.ParseException;

/**
 * The class that starts the application.
 */
public class MainApplication {

    /**
     * Main method that loads all previous data, runs the program, then saves the modified data.
     * In case there are no previous users, it will call the AddAdmin Use case to create the first admin.
     * @param args input arguments - part of public static void main method.
     */
    public static void main(String[] args) {
        try {
            DatabaseConnector dc1 = new UserTrackerConnector();
            DatabaseConnector dc2 = new FlightTrackerConnector();
            if (dc1.checkEmpty()){ // Check if file is empty. If empty then create first admin.
                AddAdmin.addFirstAdmin();
                dc1.save();
            }
            if (dc2.checkEmpty()){
                AddFlight.addFirstFlight();
                AddFlight.GenerateFlights();
                dc2.save();
            }
            DatabaseConnector dc3 = new TicketConnector();
            DatabaseConnector dc4 = new PaymentConnector();
            dc1.load();
            dc2.load();
            dc3.load();
            dc4.load();
            // Call LoginMenu ...
            LoginMenu.loginPage();
            dc1.save();
            dc2.save();
            dc3.save();
            dc4.save();
        } catch (IOException e) {
            System.out.println("Failed to perform operations on the database file. Please make sure the file " +
                    "permissions are set correctly and try again.");
        } catch (ParseException e) {
            System.out.println("Failed to parse data in the database. You are probably using an older version of the " +
                    "database that is not compatible with the current version of program. Please reset the database " +
                    "by deleting the old database file and try again.");
        }

    }
}
