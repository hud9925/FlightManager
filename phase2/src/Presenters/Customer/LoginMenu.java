package Presenters.Customer;

import Presenters.Admin.AdminMenu;
import Presenters.Console;
import UseCases.Customer.LoginUseCase;

import java.util.ArrayList;

/**
 * Presenter class that prompts user to input their User credentials
 */
public class LoginMenu {

    public static ArrayList<Boolean> getCred(String username, String password){
        return LoginUseCase.userType(username, password);
    }
    /**
     * Method that prompts the user to enter their login credentials
     * If the credentials don't exist, another prompt to go back or to continue.
     */

    private static void loginPrompt() {
        String username = Console.prompt("Enter Username : ", ".+");
        String password = Console.prompt("Enter Password : ", ".+");

        // Check credential existence by contacting UserType method from Login Use Case class.
        ArrayList<Boolean> credPredicates = getCred(username, password);
        // The array list of predicates indicate:
        // 1. whether the username/password matches;
        // 2. whether the user is admin.
        if (!credPredicates.get(0)){
            String ans = Console.prompt(new String[] {
                    "Either your username or password is incorrect. Please try again.",
                    "Enter any letter except B to continue or enter B to go back to login page.",
                    "Continue?"
            });
            if (ans.equalsIgnoreCase("b")){
                loginPage();
            } else {
                loginPrompt();
            }
        }
        else {
            if (!credPredicates.get(1)){
                MainMenu.mainPage(username);
            } else {
                AdminMenu.adminPrompt(username);
            }
        }
    }

    /**
     * Main prompt method to display the login page. Asks the User if they want to register, login or quit.
     */
    public static void loginPage() {
        String ans = Console.prompt(new String[]{
                "Welcome to the air ticket reserving system login page!",
                "If you are an existing user, please enter 'E'. If you are new user, you need to register an " +
                        "account, to do so, please enter 'R'.",
                "Press 'Q' to exit.",
                "Existing user or New user? (E/R) : "
        }, "^[erq]$");
        if (ans.equalsIgnoreCase("e")){
            LoginMenu.loginPrompt();
        }
        else if (ans.equalsIgnoreCase("r")){
            RegisterMenu.registerPrompt();
        }
        else if (ans.equalsIgnoreCase("q")){
            System.out.println("You are going to quit this program. Thank you for using.");
        }
    }
}
