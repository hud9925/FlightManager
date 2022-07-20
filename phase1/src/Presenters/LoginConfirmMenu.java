package Presenters;

import Entities.User.TicketAlreadyExistsException;
import UseCases.*;

/**
 * A Presenter that Prompts the User to Re-Enter their Login Information;
 *
 */
public class LoginConfirmMenu {
    public static String LoginConfirmPrompt() throws FlightNotFoundException, TicketAlreadyExistsException {
        String username = Console.prompt("Enter Username : ", ".+");
        String password = Console.prompt("Enter Password : ", ".+");
        // Checking Credentials Through Contacting LoginUseCase
        if (LoginUseCase.UserType(username, password).get(0)){
            System.out.println("Thank you! Ticket has been Purchased!");
            return username;
        }
        else { //.UserType(username, password).get(0)) is false
            String reprompt = Console.prompt("Either your username or password is incorrect. Please try again." +
                            "Please Enter 't' to try again, or 'e' to exit to the flight menu.");
            if (reprompt.equalsIgnoreCase("t")){
                LoginConfirmPrompt();
            }
            else {
                new FlightMenu();
            }
        }
        return username;
    }
}
