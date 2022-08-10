package Presenters.Customer;

import Controllers.MainMenuC;
import Presenters.Console;

/**
 * Presenter class, first page of the program for customers.
 */
public class MainMenu {

    /**
     * Main page of the application. Prompts the user on what they want to do.
     * Takes in their username, passes their answer and their username to the associated controller.
     *
     * @param username The username of the current user.
     */
    public static void mainPage(String username) {
        String ans = Console.prompt(new String[] {
                "Welcome to the air ticket reserving system!",
                "- 1: See a list of available flights.",
                "- 2: Cancel a ticket.",
                "- 3: View account details.",
                "- 4: Open the membership dashboard.",
                "- 5: Add a payment method to your account.",
                "To exit the program, press any other key."
        });
        new MainMenuC(username, ans);
    }
}
