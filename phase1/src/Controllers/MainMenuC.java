package Controllers;

import Presenters.CancelMenu;
import Presenters.FlightMenu;
import UseCases.GetUser;

public class MainMenuC {

    public MainMenuC(String ans, String username) {
        switch (ans) {
            case "1":
                this.option1();
                break;
            case "2":
                this.option2();
                break;
            case "3":
                this.option3(username);
                break;
            default:
                this.exit();
                break;
        }
    }
    public void option1(){
        new FlightMenu();
    }
    public void option2(){
        new CancelMenu();
    }
    public void option3(String username){
        System.out.println(new GetUser().ReturnUser(username));
    }
    public void exit(){
        System.out.println("Program is closing.");
    }
}
