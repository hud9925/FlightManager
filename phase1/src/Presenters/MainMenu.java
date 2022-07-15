package Presenters;

import Controllers.MainMenuC;

public class MainMenu {

    public static void mainPage(String username) {
        String ans = Console.prompt(new String[] {
                "Welcome to the air ticket reserving system!",
                "To see a list of flights, press 1.",
                "To cancel a ticket, press 2.",
                "To see your account details, press 3.",
                "To exit the program, press any other key."
        });
        new MainMenuC(ans, username);
    }
}
