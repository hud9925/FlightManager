package Controllers;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import Presenters.Customer.FlightMenu;
import Presenters.Customer.MainMenu;
import Presenters.Customer.PurchaseMenu;
import UseCases.FlightNotFoundException;
import UseCases.Customer.GetFlightList;


/**
 * A Controller for the FlightMenu Presenter class that takes the user's input
 * and send it to PurchaseMenu.
 */
public class FlightMenuC {

    /**
     * Takes the user's input from the FlightMenu presenter and either directs them to PurchaseMenu
     * or allows them to go back to the main page.
     * @param flightId ID of the flight
     * @throws FlightNotFoundException if the flight does not exist
     * @throws TicketAlreadyExistsException if the ticket already exists
     */
    public FlightMenuC(String flightId) throws FlightNotFoundException, TicketAlreadyExistsException {
        if (GetFlightList.flightMap().containsKey(flightId)) {
            PurchaseMenu.purchaseMenuPrompt(flightId);
        } else if (flightId.equalsIgnoreCase("back")) {
            try {
                MainMenu.mainPage();
            } catch (TicketNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            FlightMenu.flightError();
        }
    }
}


