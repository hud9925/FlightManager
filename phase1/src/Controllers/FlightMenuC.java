package Controllers;

import Presenters.FlightMenu;

/**
 * A Controller that calls upon a Presenter
 * and sends the User's Input to PurchaseMenu
 */

public class FlightMenuC {
    public FlightMenuC(String flightid){
        FlightMenu.ShowDestinations();

        //PurchaseMenu.PurchaseMenuPrompt(FlightMenu.SelectFlight());

    }


}
