package ControllersAndPresenters;

import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {
    public static void loginPrompt(){
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String username = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter Password : ");
        String password = input2.next();

        // Codes reserved for contacting LoginUseCase class.
    }
    public static void main(String[] args) {
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
             RegisterMenu.registerPrompt();
        }
        else if (Objects.equals(ans, "Q") || Objects.equals(ans, "q")){
            System.out.println("You are going to quit this program. Thank you for using.");
            System.exit(0);
        }
    }
}
