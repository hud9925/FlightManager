package Presenters.Customer;

import Presenters.Console;
import UseCases.Customer.RegisterUseCase;

import java.time.LocalDate;

/**
 * Presenter class that prompts a new user to input their relevant information to register
 */
public class RegisterMenu {

    /**
     * Method that prompts the user to enter their relevant information
     * If the username already exists, then prompt to either retry or to go back.
     */
    public static void registerPrompt() {
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


        if (!RegisterUseCase.newUser(username, password, LocalDate.parse(year + "-" + month + "-" + day),
                email)){ //false = Username is already registered.
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
        else { //true = Username is available.
            System.out.println("Account created successfully!");
            MainMenu.mainPage(username); // Call main menu.
        }

    }
}
