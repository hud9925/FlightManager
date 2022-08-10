package Presenters.Admin;

import Controllers.AdminFlightC;
import Presenters.Console;

/*
 * This is the presenter class of Admin Menu -> Admin Flight, with some controlling methods (add/cancel)
 * redirected to the Admin Flight controller class.
 */
public class AdminFlight {
    /**
     * The page showing the admin's flight control.
     *
     * @param username The username of the current user.
     */
    public static void adminFlightPrompt(String username) {
        String choice = Console.prompt(new String[]{
                "You have now reached Admin - Flight page. Enter the following number key to continue:\n" +
                "- 1: Show all available flights;\n" +
                        "- 2: Add a flight;\n" +
                        "- 3: Cancel a flight\n" +
                        "- 4: Remove all flights\n"+
                        "- 5: Edit a flight's data\n" +
                        "To go back, press any other key."
        });
        new AdminFlightC(username, choice);
    }
}
