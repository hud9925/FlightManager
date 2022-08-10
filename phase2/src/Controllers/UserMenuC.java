package Controllers;

import Presenters.Admin.AddAdminMenu;
import Presenters.Admin.AdminMenu;
import Presenters.Admin.DeleteUserMenu;
import UseCases.Admin.DeleteUser;

/**
 * Controller class containing options for the admin user menu
 * Calls different menus depending on the admin's choice
 */
public class UserMenuC {

    /**
     * Constructor taking in the admin's choice as to what they want to do: add an admin, delete a user or to go back
     * Allocates to option methods depending on the user's choice
     *
     * @param username The username of the current user.
     * @param ans The admin's choice
     */
    public UserMenuC(String username, String ans) {
        switch (ans){
            case "1":
                this.deleteUserOption();
                break;
            case "2":
                this.addAdminOption(username);
                break;
            case "3":
                this.deleteAllOption(username);
                break;
            default:
                this.back(username);
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
     *
     * @param username The username of the current user.
     */
    public void addAdminOption(String username) {
        AddAdminMenu.addAdminPrompt(username);
    }
    /**
     * Option method 3: Deletes all users except the current user
     *
     * @param username The username of the current user (to keep).
     */
    public void deleteAllOption(String username){
        DeleteUser.ClearAllUsers(username);
    }
    public void back(String username) {
        AdminMenu.adminPrompt(username);
    }
}
