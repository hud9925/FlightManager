package Controllers;

import Presenters.PurchaseMenu;
import UseCases.FlightNotFoundException;


/**
 * A Controller that calls upon a Presenter
 * and sends the User's Input to PurchaseMenu
 */

public class FlightMenuC {
    public FlightMenuC(String flightid) throws FlightNotFoundException {
        PurchaseMenu.PurchaseMenuPrompt(flightid);
        }
    }


