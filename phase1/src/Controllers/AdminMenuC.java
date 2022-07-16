package Controllers;

import Presenters.UserMenu;

import java.io.IOException;

public class AdminMenuC {

    public AdminMenuC(String ans) throws IOException {
        switch (ans){
            case "1":
                this.option1();
                break;
            case "2":
                this.option2();
                break;
            default:
                this.exit();
                break;
        }
    }

    public void option1() throws IOException {
        UserMenu.UserMenuPrompt();
    }
    public void option2(){
        //AdminFlight.AdminFlightPrompt();
    }
    public void exit(){
        System.out.println("Exiting the program...");
    }

}
