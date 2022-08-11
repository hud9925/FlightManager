package Presenters.Admin;

import UseCases.Admin.DeleteUser;
import Presenters.Console;

/**
 * Presenter class that prompts admin to delete a user
 * Their input is the User's username, it takes it and passes it to the
 */
public class DeleteUserMenu {

    /**
     * Prompt that asks admin for the username of the target user to delete
     * Passes username to delete user and prints out the response
     */
    public static void removingUserPrompt() {
        String username = Console.prompt("Please enter the Username of the User you wish to delete");
        if (DeleteUser.removeUser(username)){
//                User exists and was removed
            System.out.println("User has been Removed!") ;
        } else{
//                User does not exist
            System.out.println("This User does not exist");
        }
        System.out.println("Redirecting to main admin menu...");
    }
}
