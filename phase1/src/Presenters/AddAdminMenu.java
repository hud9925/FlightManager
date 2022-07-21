package Presenters;

import UseCases.AddAdmin;

import java.io.IOException;

public class AddAdminMenu {

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

//                Scanner create = new Scanner(System.in);
//                System.out.println("Ok! Please enter the new admins's information!\n" +
//                        "Username? ");
////            String UserName = create.next();
//                Scanner pass  = new Scanner(System.in);
//                System.out.println("Password?");
//                Scanner birthyear  = new Scanner(System.in);
//                System.out.println("Year Born?(XXXX)");
//                Scanner monthborn = new Scanner(System.in);
//                System.out.println("Month Born(MM)?");
//                System.out.println("Day Born(DD)?");
//                Scanner dayborn = new Scanner(System.in);
//                System.out.println("Email Address?");
//                Scanner email = new Scanner(System.in);
//                System.out.println("Member status? (Member or not? Yes or No)");
//                Scanner member = new Scanner(System.in);


        AddAdmin.NewAdmin(username, password, Integer.parseInt(year), Integer.parseInt(month),
                Integer.parseInt(day), email);

        System.out.println("Admin Created!");
        UserMenu.UserMenuPrompt();
    }
}
