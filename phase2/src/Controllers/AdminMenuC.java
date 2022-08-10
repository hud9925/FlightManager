package Controllers;

import Presenters.Admin.AdminFlight;
import Presenters.Admin.UserMenu;

/**
 * Controller class for the AdminMenu presenter class. Takes the admin user's input from AdminMenu and
 * directs them to the option corresponding to their input.
 */
public class AdminMenuC {

    /**
     * Takes the user's input from AdminMenu. If option 1 is chosen, the admin user is able to add
     * or delete users. If option 2 is chosen, the admin user is able to add or cancel flights.
     *
     * @param username The username of the current user.
     * @param ans the option chosen by the admin user
     */
    public AdminMenuC(String username, String ans) {
        switch (ans){
            case "1":
                this.userMenuOption(username);
                break;
            case "2":
                this.adminFlightOption(username);
                break;
            default:
                this.exit();
                break;
        }
    }

    /**
     * Option method redirecting the admin to the user menu
     *
     * @param username The username of the current user.
     */
    private void userMenuOption(String username) {
        UserMenu.userMenuPrompt(username);
    }

    /**
     * Option method redirecting the admin to the flight menu
     *
     * @param username The username of the current user.
     */
    private void adminFlightOption(String username) {
        AdminFlight.adminFlightPrompt(username);
    }
    /**
     * Option method that notifies the admin about quitting the program
     */
    private void exit(){
        System.out.println("Exiting the program...");
    }

}
