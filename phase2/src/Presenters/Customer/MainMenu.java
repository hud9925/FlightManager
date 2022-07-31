package Presenters.Customer;

import Controllers.MainMenuC;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import UseCases.FlightNotFoundException;

/**
 * Presenter class, first page of the program for customers.
 */
public class MainMenu {

    /**
     * Main page of the application. Prompts the user on what they want to do.
     * Takes in their username, passes their answer and their username to the associated controller.
     */
    public static void mainPage() throws FlightNotFoundException, TicketAlreadyExistsException, TicketNotFoundException {
        String ans = Console.prompt(new String[] {
                "Welcome to the air ticket reserving system!",
                "To see a list of flights, press 1.",
                "To cancel a ticket, press 2.",
                "To see your account details, press 3.",
                "To exit the program, press any other key."
        });
        new MainMenuC(ans);
    }
}
