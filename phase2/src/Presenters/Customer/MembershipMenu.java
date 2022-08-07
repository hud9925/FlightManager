package Presenters.Customer;


import Controllers.MembershipMenuC;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import UseCases.FlightNotFoundException;
import UseCases.Admin.GetUser;

/**
 * Presenter class for the Membership Menu.
 */
public class MembershipMenu {

    /**
     * Method that determines whether a user is a member. If they are, they can purchase exclusive
     * flights or cancel their membership status.
     * If they are not a member, they may register to become one, or they can return to the main menu.
     */
    public static void membershipMenuPrompt() throws FlightNotFoundException, TicketAlreadyExistsException,
            TicketNotFoundException{
        String username = Console.prompt("Please enter your username.");

        if (GetUser.returnUser(username).getMemberStatus()){
            String action = Console.prompt(new String[]{
                    "Welcome back, " + username + "!",
                    "You have " + GetUser.returnUser(username).getLoyaltyPoints() + " points",
                    "To view a list of available exclusive flights, enter 1.",
                    "To return to the Main Menu, enter 2.",
                    "To cancel your membership status, enter 3."
            }, "^[0-9]");
            int choice = Integer.parseInt(action);
            new MembershipMenuC(choice, username);

        } else {
            String choice = Console.prompt(new String[]{
                    "You are not a member yet. Would you like to become one? \n" +
                            "Enter 'yes' if you would.\n" +
                            "Enter anything else to return to the main menu.\n"
            });
            new MembershipMenuC(choice, username);
        }
    }
}
