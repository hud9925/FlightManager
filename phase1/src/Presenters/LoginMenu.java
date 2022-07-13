package Presenters;

import Gateways.UserTrackerConnector;
import UseCases.LoginUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {
    public static void loginPrompt() throws IOException {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String username = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter Password : ");
        String password = input2.next();

        // Check credential existence by contacting UserType method from Login Use Case class.
        ArrayList<Boolean> credPredicates = LoginUseCase.UserType(username, password);
        // The array list of predicates indicate:
        // 1. whether the username/password matches;
        // 2. whether the user is admin.
        if (!credPredicates.get(0) && !credPredicates.get(1)){ //[false, false]
            System.out.println("Either your username or password is incorrect. Please try again.\n" +
                    "Enter any letter except B to continue or enter B to go back to login page.\n");
            Scanner input3 = new Scanner(System.in);
            System.out.println("Continue?: ");
            String ans =  input3.next();
            if (Objects.equals(ans, "B") || Objects.equals(ans, "b")){
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
        System.out.println("Welcome to the air ticket reserving system login page!\n" +
                "If you are an existing user, please enter 'E'. If you are new user, you need to register an account," +
                "to do so, please enter 'R'.\n" +
                "Press 'Q' to exit.");

        Scanner input0 = new Scanner(System.in);
        System.out.println("Existing user or New user? (E/R) : ");
        String ans = input0.next();
        if (Objects.equals(ans, "E") || Objects.equals(ans, "e")){
            LoginMenu.loginPrompt();

        }
        else if (Objects.equals(ans, "R") || Objects.equals(ans, "r")){
            RegisterMenu.registerPage();
        }
        else if (Objects.equals(ans, "Q") || Objects.equals(ans, "q")){
            System.out.println("You are going to quit this program. Thank you for using.");
            UserTrackerConnector dc = new UserTrackerConnector();
            dc.Save();
            System.exit(0);
        }

        else {
            System.out.println("You entered an incorrect command and will be redirected to the login menu.");
            loginPage();
        }
    }
}
