package Presenters;

import Gateways.UserTrackerConnector;
import UseCases.LoginUseCase;

import java.io.IOException;
import java.util.ArrayList;

public class LoginMenu {
    public static void loginPrompt() throws IOException {
        String username = Console.prompt("Enter Username : ", ".+");
        String password = Console.prompt("Enter Password : ", ".+");

        // Check credential existence by contacting UserType method from Login Use Case class.
        ArrayList<Boolean> credPredicates = LoginUseCase.UserType(username, password);
        // The array list of predicates indicate:
        // 1. whether the username/password matches;
        // 2. whether the user is admin.
        if (!credPredicates.get(0) && !credPredicates.get(1)){ //[false, false]
            String ans = Console.prompt(new String[] {
                    "Either your username or password is incorrect. Please try again.",
                    "Enter any letter except B to continue or enter B to go back to login page.",
                    "Continue?"
            });
            if (ans.equalsIgnoreCase("b")){
                loginPage();
            }
            else{
                loginPrompt();
            }
        }
        else { // [true, ?], i.e.
            if (!credPredicates.get(1)){ // If the user account is not admin
                MainMenu.mainPage(username); // Call main menu
            }
            //
             else { // if the user account is admin
                AdminMenu.AdminPrompt(); // Call AdminMenu
            }
        }

    }

    public static void loginPage() throws IOException {
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
            RegisterMenu.registerPage();
        }
        else if (ans.equalsIgnoreCase("q")){
            System.out.println("You are going to quit this program. Thank you for using.");
            UserTrackerConnector dc = new UserTrackerConnector();
            dc.Save();
            System.exit(0);
        }
    }
}
