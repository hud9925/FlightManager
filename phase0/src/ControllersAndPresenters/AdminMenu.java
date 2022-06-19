package ControllersAndPresenters;
import UseCases.AddAdmin;
import UseCases.DeleteUser;

import java.util.Objects;
import java.util.Scanner;

    public class AdminMenu {
        public static void AdminPrompt() {
            System.out.println("Welcome to the admin menu!\n" +
                    "please press A to add a new admin,\n" + "D to delete and existing User within the system,\n"+
                "or any other letter to logout the menu");
            Scanner decision = new Scanner(System.in);
            String ans = decision.next();
            if (Objects.equals(ans, "A") || Objects.equals(ans, "a")){
//            adding a new admin
                Scanner create = new Scanner(System.in);
                System.out.println("Ok! Please enter the new admins's information!\n" +
                        "Username? ");
//            String UserName = create.next();
                Scanner pass  = new Scanner(System.in);
                System.out.println("Password?");
                Scanner birthyear  = new Scanner(System.in);
                System.out.println("Year Born?");
                Scanner monthborn = new Scanner(System.in);
                System.out.println("Month Born?");
                System.out.println("Day Born?");
                Scanner dayborn = new Scanner(System.in);
                System.out.println("Email Address?");
                Scanner email = new Scanner(System.in);
                System.out.println("Member status? (Member or not? Yes or No)");
                Scanner member = new Scanner(System.in);
                if (Objects.equals(member.next(), "Yes")|| Objects.equals(member.next(), "yes" )){
                    boolean MemberStatus = true;
                    AddAdmin.NewAdmin(create.next(), pass.next(), birthyear.nextInt(), monthborn.nextInt(), dayborn.nextInt(), email.next(), MemberStatus);
                    System.out.println("Admin Created!");
                    System.out.println("Returning you to the AdminMenu");
                    AdminMenu.AdminPrompt();
                } else {
                    boolean MemberStatus = false;
                    AddAdmin.NewAdmin(create.next(), pass.next(), birthyear.nextInt(), monthborn.nextInt(), dayborn.nextInt(), email.next(), MemberStatus);
                    System.out.println("Admin Created!");
                    System.out.println("Returning you to the AdminMenu");
                    AdminMenu.AdminPrompt();
                }


//      Deleting an User
            } else if (Objects.equals(ans, "D") || Objects.equals(ans, "d")){
                AdminMenu.RemovingUserPrompt();
                System.out.println("Would you like to remove another user? Yes/No");
                Scanner AnotherUser = new Scanner(System.in);
                if (Objects.equals(AnotherUser.next(), "Yes")|| Objects.equals(AnotherUser.next(), "yes")){
                    AdminMenu.RemovingUserPrompt();
                } else if (Objects.equals(AnotherUser.next(), "No")|| Objects.equals(AnotherUser.next(), "no")){
                    System.out.println("Returning you to the AdminMenu");
                    AdminMenu.AdminPrompt();
                } else {
                    System.out.println("You have failed to answer a Yes or No Question. Returning you to Admin Menu");
                    AdminMenu.AdminPrompt();

                }

            } else {
                System.out.println("Thank you! Logging out...");
                LoginMenu.loginPrompt();

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


