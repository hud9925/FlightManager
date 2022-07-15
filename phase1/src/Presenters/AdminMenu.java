package Presenters;
import UseCases.AddAdmin;
import UseCases.DeleteUser;

import java.io.IOException;

    public class AdminMenu {
        public static void AdminPrompt() throws IOException {
            String ans = Console.prompt(new String[]{
                    "Welcome to the admin menu!",
                    "Please press 'A' to add a new admin,",
                    "'D' to delete an existing User within the system,",
                    "or any other letter to logout the menu"
            });
            if (ans.equalsIgnoreCase("a")){
//            adding a new admin
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
                String MemberStatus = Console.prompt("Please enter the new admin's member status (Yes/No): ",
                        "^((yes)|(no))$");

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
                        Integer.parseInt(day), email, MemberStatus.equalsIgnoreCase("yes"));

                System.out.println("Admin Created!");
                System.out.println("Returning you to the AdminMenu");
                AdminMenu.AdminPrompt();


//      Deleting an User
            } else if (ans.equalsIgnoreCase("d")){
                AdminMenu.RemovingUserPrompt();
                String newans = Console.prompt("Would you like to remove another user? (Yes/No) ",
                        "^((yes)|(no))$");
                if (newans.equalsIgnoreCase("yes")){
                    AdminMenu.RemovingUserPrompt();
                } else {
                    System.out.println("Returning you to the AdminMenu");
                    AdminMenu.AdminPrompt();
                }
            } else {
                System.out.println("Thank you! Logging out...");
                LoginMenu.loginPage();

            }

        }
        public static void RemovingUserPrompt() throws IOException {
            String username = Console.prompt(new String[]{
                    "Please enter the Username of the User you wish to delete,",
                    "leave the input blank to return to the top of the admin menu:"
            });
            if (username.equals("")) {
                AdminMenu.AdminPrompt();
            }
            if (DeleteUser.RemoveUser(username)){
//                User exists and was removed
                System.out.println("User has been Removed!") ;
            } else{
//                User does not exist
                System.out.println("This User does not exist");
                AdminMenu.AdminPrompt();
            }

        }

    }


