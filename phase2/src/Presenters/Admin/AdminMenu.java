package Presenters.Admin;

import Controllers.AdminMenuC;
import Presenters.Console;


/**
 * Presenter class that shows the Admin user options on what they want to do.
 */
public class AdminMenu {
    /**
     * Prompt method that displays the admin options, takes in their input and sends it to the controller class
     *
     * @param username The username of the current user.
     */
    public static void adminPrompt(String username) {
        String ans = Console.prompt(new String[]{
                "Welcome to the admin menu!",
                "- 1: See a list of existing users to add an admin or delete a user.",
                "- 2: See a list of flights to add or cancel a flight.",
                "To log out, press any other key."
        });
        new AdminMenuC(username, ans);
    }
}
