package Controllers;

import Entities.User.TicketAlreadyExistsException;
import Presenters.FlightMenu;
import Presenters.PurchaseMenu;
import UseCases.FlightNotFoundException;
import UseCases.GetFlightList;


/**
 * A Controller that calls upon a Presenter
 * and sends the Input to PurchaseMenu
 */

public class FlightMenuC {
    public FlightMenuC(String flightid) throws FlightNotFoundException, TicketAlreadyExistsException {
        if (GetFlightList.FlightMap().containsKey(flightid)){
            PurchaseMenu.PurchaseMenuPrompt(flightid);
        } else if (flightid.equals("exit")) {
            System.out.println("Program Closing");
            System.exit(0);
        } else {
            FlightMenu.FlightError();
        }
        }
    }


