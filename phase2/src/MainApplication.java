import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import Gateways.*;
import Presenters.Customer.LoginMenu;
import UseCases.Admin.AddAdmin;
import UseCases.Admin.AddFlight;
import UseCases.FlightNotFoundException;

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
     * @throws IOException disregards any input that is invalid
     * @throws ParseException disregards if the input string cannot be parsed correctly.
     */
    public static void main(String[] args) throws IOException, ParseException, FlightNotFoundException, TicketAlreadyExistsException, TicketNotFoundException {
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
    }
}
