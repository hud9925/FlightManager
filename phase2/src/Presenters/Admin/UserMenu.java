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
     *
     * @param username The username of the current user.
     */
    public static void userMenuPrompt(String username) {
        String ans = Console.prompt(new String[] {
                "Here is the current list of users:",
                GetUser.returnAllUsers(),
                "- 1: Delete a user.",
                "- 2: Add an admin.",
                "- 3: Delete all users except yourself.",
                "To go back, press any other key."
        });
        new UserMenuC(username, ans);
    }

}
