package Controllers;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import Presenters.Customer.*;
import UseCases.FlightNotFoundException;
import UseCases.Admin.GetUser;

/**
 * Controller class containing options for the main menu
 * Calls different menus depending on the user's choice
 */
public class MainMenuC {

    /**
     * Constructor, taking in the user's answer on what they want to do and also their username
     * Allocates to option methods depending on the user's choice
     * @param ans the user's choice
     */
    public MainMenuC(String ans) {
        switch (ans) {
            case "1":
                this.flightMenuOption();
                break;
            case "2":
                this.cancelMenuOption();
                break;
            case "3":
                this.accountInfoOption();
                break;
            case "4":
                this.membershipMenuOption();
                break;
            case "5":
                this.paymentMethodOption();
                break;
            default:
                this.exit();
                break;
        }
    }

    /**
     * First option method: directs user to the flight menu
     */
    public void flightMenuOption() {
        FlightMenu.flightMenuPrompt();
    }
    /**
     * Second option method: directs user to the cancel menu
     */
    public void cancelMenuOption() {
        CancelMenu.cancelMenuPrompt();
    }
    /**
     * Third option method: formats and displays the user's stored information
     * Takes in the user's username, retrieves their data from GetUser Use Case class
     */
    public void accountInfoOption(){
        String username = UsernameMenu.getUsernamePrompt();
        String[] userdata = GetUser.returnUser(username).toString().split(",");
        System.out.println("Username: " + userdata[0] + "\nPassword: " + userdata[1] + "\nBirthday: " + userdata[2] +
                "\nEmail: " + userdata[3] + "\nMember Status: " + userdata[4] + "\nLogin dates: " + userdata[5]);
        MainMenu.mainPage();
    }
    /**
     * Fourth option method: directs the user to the Membership Menu.
     */
    public void membershipMenuOption() {
        MembershipMenu.membershipMenuPrompt();
    }
    /**
     * Exit option: displays a message.
     */

    public void paymentMethodOption() { paymentMenu.paymentMenuPrompt();}
    public void exit(){
        System.out.println("Program is closing...");
    }
}
