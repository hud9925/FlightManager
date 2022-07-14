package Presenters;

import Controllers.MainMenuC;

import java.util.Scanner;

public class MainMenu {

    public static void mainPage(String username) {

        Scanner input0 = new Scanner(System.in);
        System.out.println("Welcome to the air ticket reserving system! \n To " +
                "see a list of flights, press 1. \n To cancel a ticket, press 2. \n To see your account details," +
                "press 3.\n To exit the program, press any other key.");
        String ans = input0.next();
        new MainMenuC(ans, username);
    }
}
