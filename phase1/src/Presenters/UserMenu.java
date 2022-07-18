package Presenters;

import Controllers.UserMenuC;
import UseCases.GetUser;

import java.io.IOException;

public class UserMenu {

    public static void UserMenuPrompt() throws IOException {
        String ans = Console.prompt(new String[] {
                "Here is the current list of users:",
                new GetUser().ReturnAllUsers(),
                "To delete a user, press 1.",
                "To add an admin, press 2.",
                "To go back, press any other key."
        });
        new UserMenuC(ans);
    }

}
