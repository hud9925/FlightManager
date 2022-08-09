package Presenters.Admin;

import Controllers.AdminMenuC;


/**
 * Presenter class that shows the Admin user options on what they want to do.
 */
public class AdminMenu {
    /**
     * Prompt method that displays the admin options, takes in their input and sends it to the controller class
     */
    public static void adminPrompt() {
        String ans = Console.prompt(new String[]{
                "Welcome to the admin menu!",
                "Press 1 to see a list of existing users to add an admin or delete a user.",
                "Press 2 to see a list of flights to add or cancel a flight.",
                "Press any other key to logout."
        });
        new AdminMenuC(ans);
    }
}
