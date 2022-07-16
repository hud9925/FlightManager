package Presenters;

import UseCases.DeleteUser;

import java.io.IOException;

public class DeleteUserMenu {
    public static void RemovingUserPrompt() throws IOException {
        String username = Console.prompt(new String[]{
                "Please enter the Username of the User you wish to delete,",
                "Leave the input blank to go back to the User Menu list."
        });
        if (DeleteUser.RemoveUser(username)){
//                User exists and was removed
            System.out.println("User has been Removed!") ;
        } else{
//                User does not exist
            System.out.println("This User does not exist");
        }
        UserMenu.UserMenuPrompt();
    }
}
