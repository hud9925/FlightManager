package Controllers;

import Presenters.Admin.AdminFlight;
import Presenters.Admin.UserMenu;

import java.io.IOException;

/**
 * Controller class for the AdminMenu presenter class. Takes the admin user's input from AdminMenu and
 * directs them to the option corresponding to their input.
 */
public class AdminMenuC {

    /**
     * Takes the user's input from AdminMenu. If option 1 is chosen, the admin user is able to add
     * or delete users. If option 2 is chosen, the admin user is able to add or cancel flights.
     * @param ans the option chosen by the admin user
     * @throws IOException if the admin user's input is invalid
     */
    public AdminMenuC(String ans) throws IOException {
        switch (ans){
            case "1":
                this.userMenuOption();
                break;
            case "2":
                this.adminFlightOption();
                break;
            default:
                this.exit();
                break;
        }
    }

    /**
     * Option method redirecting the admin to the user menu
     */
    public void userMenuOption() throws IOException {
        UserMenu.UserMenuPrompt();
    }

    /**
     * Option method redirecting the admin to the flight menu
     */
    public void adminFlightOption() throws IOException {
        AdminFlight.AdminFlightPrompt();
    }
    /**
     * Option method that notifies the admin about quitting the program
     */
    public void exit(){
        System.out.println("Exiting the program...");
    }

}
