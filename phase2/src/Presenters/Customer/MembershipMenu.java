package Presenters.Customer;


import Controllers.MembershipMenuC;
import Presenters.Console;
import UseCases.Admin.GetUser;

/**
 * Presenter class for the Membership Menu.
 */
public class MembershipMenu {

    /**
     * Method that determines whether a user is a member. If they are, they can purchase exclusive
     * flights or cancel their membership status.
     * If they are not a member, they may register to become one, or they can return to the main menu.
     *
     * @param username The username of the current user.
     */
    public static void membershipMenuPrompt(String username) {
        if (GetUser.returnUser(username).getMemberStatus()){
            String action = Console.prompt(new String[]{
                    "Welcome back, " + username + "!",
                    "You have " + GetUser.returnCustomer(username).getLoyaltyPoints() + " points",
                    "- 1: Cancel your membership status.",
                    "- 2: Purchase a flight ticket",
                    "To go back to the main menu, press any other key."
            });
            new MembershipMenuC(action, username);

        } else {
            String choice = Console.prompt(new String[]{
                    "You are not a member yet. Would you like to become one? \n" +
                            "- 3: Yes.\n" +
                            "To go back to the main menu, press any other key.\n"
            });
            new MembershipMenuC(choice, username);
        }
    }
}
