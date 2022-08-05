package Presenters.Admin;

import Controllers.AdminFlightC;

import java.io.IOException;

/*
 * This is the presenter class of Admin Menu -> Admin Flight, with some controlling methods (add/cancel)
 * redirected to the Admin Flight controller class.
 */
public class AdminFlight {
    /**
     * The page showing the admin's flight control.
     */
    public static void adminFlightPrompt() throws IOException {
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
