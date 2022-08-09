package Presenters.Admin;

import Controllers.UserMenuC;
import UseCases.Admin.GetUser;
import Presenters.Console;

/**
 * Shows the current list of users
 * Takes user's input - prompt: want to delete a user or add an admin
 */
public class UserMenu {

    /**
     * The static method that presents the prompt to the user
     * Asks the user for input, sends it to the associated controller class
     */
    public static void userMenuPrompt() {
        String ans = Console.prompt(new String[] {
                "Here is the current list of users:",
                GetUser.returnAllUsers(),
                "To delete a user, press 1.",
                "To add an admin, press 2.",
                "To go back, press any other key."
        });
        new UserMenuC(ans);
    }

}
