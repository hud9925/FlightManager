package Controllers;

import Presenters.Admin.AddAdminMenu;
import Presenters.Admin.AdminMenu;
import Presenters.Admin.DeleteUserMenu;
import Presenters.Customer.UsernameMenu;
import UseCases.Admin.DeleteUser;

/**
 * Controller class containing options for the admin user menu
 * Calls different menus depending on the admin's choice
 */
public class UserMenuC {

    /**
     * Constructor taking in the admin's choice as to what they want to do: add an admin, delete a user or to go back
     * Allocates to option methods depending on the user's choice
     * @param ans The admin's choice
     */
    public UserMenuC(String ans) {
        switch (ans){
            case "1":
                this.deleteUserOption();
                break;
            case "2":
                this.addAdminOption();
                break;
            case "3":
                this.deleteAllOption();
                break;
            default:
                this.back();
                break;
        }
    }

    /**
     * Option method 1: Directs admin to delete user menu and its prompt
     */
    public void deleteUserOption() {
        DeleteUserMenu.removingUserPrompt();
    }
    /**
     * Option method 2: Directs admin to add admin menu and its prompt
     */
    public void addAdminOption() {
        AddAdminMenu.addAdminPrompt();
    }
    /**
     * Option method 3: Deletes all users except the current user
     */
    public void deleteAllOption(){
        String username = UsernameMenu.getUsernamePrompt();
        DeleteUser.ClearAllUsers(username);
    }
    public void back() {
        AdminMenu.adminPrompt();
    }
}
