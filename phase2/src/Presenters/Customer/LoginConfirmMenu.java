package Presenters.Customer;

import Presenters.Console;
import UseCases.Admin.GetUser;
import UseCases.Customer.LoginUseCase;

/**
 * A Presenter that Prompts the User to Re-Enter their Login Information;
 *
 */
public class LoginConfirmMenu {

    /**
     * Menu that requires the user to input their username and password to confirm their
     * purchase.
     * @return the user's username
     */
    public static String loginConfirmPrompt() {
        System.out.println("To Continue, Please re-Enter your username and password");
        String username = Console.prompt("Enter Username : ", ".+");
        String password = Console.prompt("Enter Password : ", ".+");
        // Checking Credentials Through Contacting LoginUseCase
        if (LoginUseCase.userType(username, password).get(0)){
            System.out.println("Thank you! Ticket has been Purchased!");
            GetUser.returnUser(username).updateLoyaltyPoints();
            return username;
        }
        else { //.UserType(username, password).get(0)) is false
            String RePrompt = Console.prompt("Either your username or password is incorrect. Please try again." +
                            "Please Enter 't' to try again, or enter any other character to go back to the flight menu.");
            if (RePrompt.equalsIgnoreCase("t")){
                loginConfirmPrompt();
            }
            else {
                return "exit";
            }
        }

        return username;
    }
}
