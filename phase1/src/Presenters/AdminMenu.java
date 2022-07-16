package Presenters;

import Controllers.AdminMenuC;

import java.io.IOException;

    public class AdminMenu {
        public static void AdminPrompt() throws IOException {
            String ans = Console.prompt(new String[]{
                    "Welcome to the admin menu!",
                    "Press 1 to see a list of existing users to add an admin or delete a user.",
                    "Press 2 to see a list of flights to add or cancel a flight.",
                    "Press any other key to logout."
            });
            new AdminMenuC(ans);
        }

    }


