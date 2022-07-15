package Presenters;

import UseCases.RegisterUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RegisterMenu {

    public static void registerPrompt() throws IOException {
        String username = Console.prompt("Please enter your new username: ", ".+");
        String password = Console.prompt("Please enter your new password: ", ".+");
        String year = Console.prompt("Please enter your birth YEAR (YYYY): ",
                "^((19\\d{2})|(20(((0|1)\\d)|(2(1|2)))))$");
        String month = Console.prompt("Please enter your birth MONTH (MM): ",
                "^((0?[1-9])|(1[0-2]))$");
        String day = Console.prompt("Please enter your birth DAY (DD): ",
                "^((0?[1-9])|([12]\\d)|(3[01]))$");
        String email = Console.prompt("Please enter your email address: ",
                "^[^@]+@[^@]+\\.[^@]+$");

//      Check credential existence.
        ArrayList<Boolean> credPredicate = RegisterUseCase.NewUser(username, password,
                Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), email);

        if (!credPredicate.get(0)){ //[false] i.e: Username is already registered.
            String ans = Console.prompt(new String[]{
                    "An account with this username already exists. Please try again.",
                    "Enter any letter except B to continue or enter B to go back to the landing page.",
                    "Continue?:"
            });
            if (ans.equalsIgnoreCase("b")){
                LoginMenu.loginPage(); // Return to initial landing page.
            }
            else{
                registerPrompt(); // Call register prompt again.
            }
        }
        else { // [true] i.e: Username is available.
            System.out.println("Account created successfully!");
            MainMenu.mainPage(username); // Call main menu.
        }

    }

    // Account registration page setup.
    public static void registerPage() throws IOException {
        String ans = Console.prompt(new String[]{
                "Welcome to the air ticket reserving system registration page!",
                "Please enter the following credentials in order to create an account.",
                "Press C to continue. Press B to go back",
                "Continue? (C/B):"
        }, "^[cb]$");
        if (ans.equalsIgnoreCase("b")) {
            LoginMenu.loginPage(); // Return to initial landing page.
        }
        else {
            registerPrompt(); // Call register prompt again.
        }

    }
}
