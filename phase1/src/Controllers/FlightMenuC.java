package Controllers;

import Entities.User.TicketAlreadyExistsException;
import Presenters.FlightMenu;
import Presenters.PurchaseMenu;
import UseCases.FlightNotFoundException;
import UseCases.GetFlightList;


/**
 * A Controller for the FlightMenu Presenter class that takes the user's input
 * and send it to PurchaseMenu.
 */
public class FlightMenuC {

    /**
     * Takes the user's input from the FlightMenu presenter and either directs them to PurchaseMenu
     * or allows them to exit the program.
     * @param flightId ID of the flight
     * @throws FlightNotFoundException if the flight does not exist
     * @throws TicketAlreadyExistsException if the ticket already exists
     */
    public FlightMenuC(String flightId) throws FlightNotFoundException, TicketAlreadyExistsException {
        if (GetFlightList.FlightMap().containsKey(flightId)) {
            PurchaseMenu.PurchaseMenuPrompt(flightId);
        } else if (flightId.equals("exit")) {
            System.out.println("Program Closing");
            System.exit(0);
        } else {
            FlightMenu.FlightError();
        }

    }
    }


