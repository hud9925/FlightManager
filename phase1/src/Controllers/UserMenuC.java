package Controllers;

import Presenters.AdminMenu;

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

    public void option1(){

    }
    public void option2(){

    }
    public void back() throws IOException {
        AdminMenu.AdminPrompt();
    }
}
