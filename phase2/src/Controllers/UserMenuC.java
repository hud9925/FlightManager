package Controllers;

import Presenters.Admin.AddAdminMenu;
import Presenters.Admin.AdminMenu;
import Presenters.Admin.DeleteUserMenu;

import java.io.IOException;

/**
 * Controller class containing options for the admin user menu
 * Calls different menus depending on the admin's choice
 */
public class UserMenuC {

    /**
     * Constructor taking in the admin's choice as to what they want to do: add an admin, delete a user or to go back
     * Allocates to option methods depending on the user's choice
     * @param ans The admin's choice
     * @throws IOException disregards any input that is invalid
     */
    public UserMenuC(String ans) throws IOException {
        switch (ans){
            case "1":
                this.option1();
                break;
            case "2":
                this.option2();
                break;
            default:
                this.back();
                break;
        }
    }

    /**
     * Option method 1: Directs admin to delete user menu and its prompt
     */
    public void option1() {
        DeleteUserMenu.removingUserPrompt();
    }
    /**
     * Option method 2: Directs admin to add admin menu and its prompt
     * @throws IOException disregards any input that is invalid
     */
    public void option2() throws IOException {
        AddAdminMenu.addAdminPrompt();
    }
    /**
     * Option method 3: Directs admin back to the main admin menu and its prompt
     * @throws IOException disregards any input that is invalid
     */
    public void back() throws IOException {
        AdminMenu.adminPrompt();
    }
}
