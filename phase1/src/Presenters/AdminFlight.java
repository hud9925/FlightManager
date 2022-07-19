package Presenters;

import Controllers.AdminFlightC;
import Controllers.AdminMenuC;
import Entities.Flight.Flight;

import java.io.IOException;
import java.util.Map;

public class AdminFlight {
    /**
     * The page showing the admin's flight control.
     */
    public static void AdminFlightPrompt() throws IOException {
        String what = Console.prompt(new String[]{
                "You have now reached Admin - Flight page. Enter the following number key to continue:\n" +
                "- 1: show all available flights;\n" +
                        "- 2: add a flight;\n" +
                        "- 3: cancel a flight\n" +
                        "- 0: back to admin menu."
        }, "^[0-9]*$");
        int whichChoice = Integer.parseInt(what);
        new AdminFlightC(whichChoice);


    }

}
