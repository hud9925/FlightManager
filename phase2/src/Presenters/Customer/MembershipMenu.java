package Presenters.Customer;


import Controllers.MembershipMenuC;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import UseCases.FlightNotFoundException;
import UseCases.Admin.GetUser;


public class MembershipMenu {

    public static void membershipMenuPrompt() throws FlightNotFoundException, TicketAlreadyExistsException,
            TicketNotFoundException{
        String username = Console.prompt("Please enter your username.");

        if (GetUser.returnUser(username).getMemberStatus()){
            System.out.println("in progress");

        } else {
            String action = Console.prompt(new String[]{
                    "You are not a member yet. Would you like to become one? \n" +
                            "Enter 1 if yes.\n" +
                            "Enter 2 if no/return to the Main Menu.\n"
            }, "^[0-9]");
            int choice = Integer.parseInt(action);
            new MembershipMenuC(choice, username);

        }
    }

}
