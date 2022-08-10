package Controllers;

import Presenters.Customer.*;
import UseCases.Admin.GetUser;

/**
 * Controller class containing options for the main menu
 * Calls different menus depending on the user's choice
 */
public class MainMenuC {

    /**
     * Constructor, taking in the user's answer on what they want to do and also their username
     * Allocates to option methods depending on the user's choice
     *
     * @param username The username of the current user.
     * @param ans the user's choice
     */
    public MainMenuC(String username, String ans) {
        switch (ans) {
            case "1":
                this.flightMenuOption(username);
                break;
            case "2":
                this.cancelMenuOption(username);
                break;
            case "3":
                this.accountInfoOption(username);
                break;
            case "4":
                this.membershipMenuOption(username);
                break;
            case "5":
                this.paymentMethodOption(username);
                break;
            default:
                this.exit();
                break;
        }
    }

    /**
     * First option method: directs user to the flight menu
     *
     * @param username The username of the current user.
     */
    private void flightMenuOption(String username) {
        FlightMenu.flightMenuPrompt(username);
    }
    /**
     * Second option method: directs user to the cancel menu
     *
     * @param username The username of the current user.
     */
    private void cancelMenuOption(String username) {
        CancelMenu.cancelMenuPrompt(username);
    }
    /**
     * Third option method: formats and displays the user's stored information
     * Takes in the user's username, retrieves their data from GetUser Use Case class
     *
     * @param username The username of the current user.
     */
    private void accountInfoOption(String username){
        String[] userdata = GetUser.returnUser(username).toString().split(",");
        if (userdata[5].endsWith("|")) {
            userdata[5] = userdata[5].substring(0, userdata[5].length()-1);
        }
        System.out.println("Username: " + userdata[0] + "\nPassword: " + userdata[1] + "\nBirthday: " + userdata[2] +
                "\nEmail: " + userdata[3] + "\nMember Status: " + userdata[4] + "\nLogin dates: " + userdata[5]);
        MainMenu.mainPage(username);
    }
    /**
     * Fourth option method: directs the user to the Membership Menu.
     *
     * @param username The username of the current user.
     */
    private void membershipMenuOption(String username) {
        MembershipMenu.membershipMenuPrompt(username);
    }

    private void paymentMethodOption(String username) { PaymentMenu.paymentMenuPrompt(username);}
    /**
     * Exit option: displays a message.
     */
    private void exit(){
        System.out.println("Program is closing...");
    }
}
