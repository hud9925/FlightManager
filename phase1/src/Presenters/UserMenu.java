package Presenters;

import Controllers.UserMenuC;
import UseCases.GetUser;

import java.io.IOException;

/**
 * Shows the current list of users
 * Takes user's input - prompt: want to delete a user or add an admin
 */
public class UserMenu {

    /**
     * The static method that presents the prompt to the user
     * Asks the user for input, sends it to the associated controller class
     * @throws IOException disregards any input that is invalid
     */

    public static void UserMenuPrompt() throws IOException {
        String ans = Console.prompt(new String[] {
                "Here is the current list of users:",
                new GetUser().ReturnAllUsers(),
                "To delete a user, press 1.",
                "To add an admin, press 2.",
                "To go back, press any other key."
        });
        new UserMenuC(ans);
    }

}
