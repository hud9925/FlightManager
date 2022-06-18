package ControllersAndPresenters;

import UseCases.LoginUseCase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {
    /**
     * This is the Login Menu presenter class code.
     */
    public static void loginPrompt(){
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String username = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter Password : ");
        String password = input2.next();

        // Check credential existence by contacting UserType method from Login Use Case class.
        ArrayList<Boolean> credPredicates = LoginUseCase.UserType(username, password);
        if (!credPredicates.get(0) || !credPredicates.get(1)){
            System.out.println("Either your username or password is incorrect. Please try again.\n" +
                    "Press any key except B to continue or press B to go back to login page.\n");
            Scanner input3 = new Scanner(System.in);
            System.out.println("Continue?: ");
            String ans = input3.next();
            if (Objects.equals(ans, "B") || Objects.equals(ans, "b")){
                loginPage();
            }
            else{
                loginPrompt();
            }
        }

    }

    public static void loginPage(){
        System.out.println("Welcome to the air ticket reserving system login page!\n" +
                "If you are an existing user, please enter 'E'. If you are new user, you need to register an account," +
                "to do so, please enter 'R'.\n" +
                "Press 'Q' to exit.");

        Scanner input0 = new Scanner(System.in);
        System.out.println("Existing user or New user? (Press E or R and then Enter) : ");
        String ans = input0.next();
        if (Objects.equals(ans, "E") || Objects.equals(ans, "e")){
            LoginMenu.loginPrompt();

        }
        else if (Objects.equals(ans, "R") || Objects.equals(ans, "r")){
            RegisterMenu.registerPage();
        }
        else if (Objects.equals(ans, "Q") || Objects.equals(ans, "q")){
            System.out.println("You are going to quit this program. Thank you for using.");
            System.exit(0);
        }

        else {
            System.out.println("You entered an incorrect command and will be redirected to the login menu.");
            loginPage();
        }
    }
}