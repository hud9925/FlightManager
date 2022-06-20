package ControllersAndPresenters;
import UseCases.AddAdmin;
import UseCases.DeleteUser;

import java.util.Objects;
import java.util.Scanner;

    public class AdminMenu {
        public static void AdminPrompt() {
            System.out.println("Welcome to the admin menu!\n" +
                    "Please press 'A' to add a new admin,\n" + "'D' to delete and existing User within the system,\n"+
                "or any other letter to logout the menu");
            Scanner decision = new Scanner(System.in);
            String ans = decision.next();
            if (Objects.equals(ans, "A") || Objects.equals(ans, "a")){
//            adding a new admin
                Scanner input0 = new Scanner(System.in);
                System.out.println("Please enter the new admin's username: ");
                String username = input0.next();
                Scanner input1 = new Scanner(System.in);
                System.out.println("Please enter the new admin's password: ");
                String password = input1.next();
                Scanner input2 = new Scanner(System.in);
                System.out.println("Please enter the new admin's birth YEAR (YYYY):");
                String year = input2.next();
                Scanner input3 = new Scanner(System.in);
                System.out.println("Please enter the new admin's birth MONTH (MM):");
                String month = input3.next();
                Scanner input4 = new Scanner(System.in);
                System.out.println("Please enter the new admin's birth DAY (DD):");
                String day = input4.next();
                Scanner input5 = new Scanner(System.in);
                System.out.println("Please enter the new admin's email address:");
                String email = input5.next();
                Scanner input6 = new Scanner(System.in);
                System.out.println("Please enter the new admin's member status? (Yes/No)");
                String MemberStatus = input6.next();

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


                if (Objects.equals(MemberStatus, "Yes")|| Objects.equals(MemberStatus, "yes" )){
                    AddAdmin.NewAdmin(username, password,
                            Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), email, true);
                    System.out.println("Admin Created!");
                    System.out.println("Returning you to the AdminMenu");
                    AdminMenu.AdminPrompt();
                } else {
                    AddAdmin.NewAdmin(username, password,
                            Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), email, false);
                    System.out.println("Admin Created!");
                    System.out.println("Returning you to the AdminMenu");
                    AdminMenu.AdminPrompt();
                }


//      Deleting an User
            } else if (Objects.equals(ans, "D") || Objects.equals(ans, "d")){
                AdminMenu.RemovingUserPrompt();
                System.out.println("Would you like to remove another user? Yes/No");
                Scanner AnotherUser = new Scanner(System.in);
                String newans = AnotherUser.next();
                if (Objects.equals(newans, "Yes")|| Objects.equals(newans, "yes")){
                    AdminMenu.RemovingUserPrompt();
                } else if (Objects.equals(newans, "No")|| Objects.equals(newans, "no")){
                    System.out.println("Returning you to the AdminMenu");
                    AdminMenu.AdminPrompt();
                } else {
                    System.out.println("You have failed to answer a Yes or No Question. Returning you to Admin Menu");
                    AdminMenu.AdminPrompt();

                }

            } else {
                System.out.println("Thank you! Logging out...");
                LoginMenu.loginPage();

            }

        }
        public static void RemovingUserPrompt(){
            System.out.println("Please enter the Username of the User you wish to delete");
            Scanner User = new Scanner(System.in);
            if (DeleteUser.RemoveUser(User.next())){
//                User exists and was removed
                System.out.println("User has been Removed!") ;
                } else{
//                User does not exist
                System.out.println("This User does not exist");

            }

        }

    }


