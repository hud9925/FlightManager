package Controllers;

import Presenters.AddAdminMenu;
import Presenters.AdminMenu;
import Presenters.DeleteUserMenu;

import java.io.IOException;

public class UserMenuC {
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

    public void option1() throws IOException {
        DeleteUserMenu.RemovingUserPrompt();
    }
    public void option2() throws IOException {
        AddAdminMenu.AddAdminPrompt();
    }
    public void back() throws IOException {
        AdminMenu.AdminPrompt();
    }
}
