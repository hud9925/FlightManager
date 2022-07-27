package Presenters;

import Controllers.AdminMenuC;

import java.io.IOException;

/**
 * Presenter class that shows the Admin user options on what they want to do.
 */
public class AdminMenu {
    /**
     * Prompt method that displays the admin options, takes in their input and sends it to the controller class
     * @throws IOException for meaningless inputs
     */
    public static void AdminPrompt() throws IOException {
        String ans = Console.prompt(new String[]{
                "Welcome to the admin menu!",
                "Press 1 to see a list of existing users to add an admin or delete a user.",
                "Press 2 to see a list of flights to add or cancel a flight.",
                "Press any other key to logout."
        });
        new AdminMenuC(ans);
    }
}
