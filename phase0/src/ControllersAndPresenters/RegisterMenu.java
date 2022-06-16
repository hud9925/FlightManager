package ControllersAndPresenters;

import UseCases.RegisterUseCase;

import java.util.Objects;
import java.util.Scanner;

public class RegisterMenu {
    public static void registerPrompt(){
        Scanner input0 = new Scanner(System.in);
        System.out.println("Please enter your new username: ");
        String ans0 = input0.next();
        // Reserved for checking the username repetition.
        // if (ans0 == ...) {}

        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter your new password: ");
        String ans1 = input1.next();

        // Reserved for contacting register use case class
        // RegisterUseCase.someMethods

    }

    public static void registerPage(){
        System.out.println("Welcome to the air ticket reserving system registration page! \n" +
                "Please enter the following credentials in order to create an account.\n" +
                "Press C to continue. Press B to go back");

        Scanner input0 = new Scanner(System.in);
        System.out.println("Continue? (C/B):");
        String ans = input0.next();

        if (Objects.equals(ans, "C") || Objects.equals(ans, "c")){
            RegisterMenu.registerPrompt();

        }

        else if (Objects.equals(ans, "B") || Objects.equals(ans, "b")){
            LoginMenu.loginPage();
        }


    }
}
