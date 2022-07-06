package ControllersAndPresenters;

import UseCases.RegisterUseCase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RegisterMenu {

    public static void registerPrompt() {
        Scanner input0 = new Scanner(System.in);
        System.out.println("Please enter your new username: ");
        String username = input0.next();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter your new password: ");
        String password = input1.next();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Please enter your birth YEAR (YYYY):");
        String year = input2.next();
        Scanner input3 = new Scanner(System.in);
        System.out.println("Please enter your birth MONTH (MM):");
        String month = input3.next();
        Scanner input4 = new Scanner(System.in);
        System.out.println("Please enter your birth DAY (DD):");
        String day = input4.next();
        Scanner input5 = new Scanner(System.in);
        System.out.println("Please enter your email address:");
        String email = input5.next();

//      Check credential existence.
        ArrayList<Boolean> credPredicate = RegisterUseCase.NewUser(username, password,
                Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), email);

        if (!credPredicate.get(0)){ //[false] i.e: Username is already registered.
            System.out.println("An account with this username already exists. Please try again.\n" +
                    "Enter any letter except B to continue or enter B to go back to the landing page.\n");
            Scanner input6 = new Scanner(System.in);
            System.out.println("Continue?:");
            String ans =  input6.next();
            if (Objects.equals(ans, "B") || Objects.equals(ans, "b")){
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
    public static void registerPage() {
        System.out.println("Welcome to the air ticket reserving system registration page! \n" +
                "Please enter the following credentials in order to create an account.\n" +
                "Press C to continue. Press B to go back");
        Scanner input0 = new Scanner(System.in);
        System.out.println("Continue? (C/B):");
        String ans = input0.next();
        if (!Objects.equals(ans, "C") && !Objects.equals(ans, "c")) {
            if (Objects.equals(ans, "B") || Objects.equals(ans, "b")) {
                LoginMenu.loginPage(); // Return to initial landing page.
            }
        } else {
            registerPrompt(); // Call register prompt again.
        }

    }
}
