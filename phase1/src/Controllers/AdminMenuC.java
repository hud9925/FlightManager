package Controllers;

import Presenters.AdminFlight;
import Presenters.UserMenu;

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
                this.option1();
                break;
            case "2":
                this.option2();
                break;
            default:
                this.exit();
                break;
        }
    }

    public void option1() throws IOException {
        UserMenu.UserMenuPrompt();
    }
    public void option2() throws IOException {
        AdminFlight.AdminFlightPrompt();
    }
    public void exit(){
        System.out.println("Exiting the program...");
    }

}
