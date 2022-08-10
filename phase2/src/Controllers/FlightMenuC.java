package Controllers;

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
     *
     * @param username The username of the current user.
     * @param flightId ID of the flight
     */
    public FlightMenuC(String username, String flightId) {
        if (GetFlightList.flightMap().containsKey(flightId)) {
            try {
                PurchaseMenu.purchaseMenuPrompt(username, flightId);
            } catch (FlightNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (flightId.equalsIgnoreCase("back")) {
            MainMenu.mainPage(username);
        } else {
            FlightMenu.flightError(username);
        }
    }
}


