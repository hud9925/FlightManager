package Presenters.Admin;

import UseCases.Admin.AddAdmin;

import java.io.IOException;

/**
 * Presenter class that prompts admin to create a new Admin, takes their input and creates an admin
 */
public class AddAdminMenu {

    /**
     * The prompt method that displays the prompts to the screen
     * It takes the User's responses and sends them to the AddAdmin Use Case to create a new admin.
     * @throws IOException for meaningless inputs.
     */
    public static void AddAdminPrompt() throws IOException {
        //adding a new admin
        String username = Console.prompt("Please enter the new admin's username: ", ".+");
        String password = Console.prompt("Please enter the new admin's password: ", ".+");

        String year = Console.prompt("Please enter the new admin's birth YEAR (YYYY): ",
                "^((19\\d{2})|(20(((0|1)\\d)|(2(1|2)))))$");
        String month = Console.prompt("Please enter the new admin's birth MONTH (MM): ",
                "^((0?[1-9])|(1[0-2]))$");
        String day = Console.prompt("Please enter the new admin's birth DAY (DD): ",
                "^((0?[1-9])|([12]\\d)|(3[01]))$");
        String email = Console.prompt("Please enter the new admin's email address: ",
                "^[^@]+@[^@]+\\.[^@]+$");

        AddAdmin.NewAdmin(username, password, Integer.parseInt(year), Integer.parseInt(month),
                Integer.parseInt(day), email);

        System.out.println("Admin Created!");
        UserMenu.UserMenuPrompt();
    }
}
