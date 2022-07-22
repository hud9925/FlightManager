package Controllers;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import Presenters.CancelMenu;
import Presenters.FlightMenu;
import UseCases.FlightNotFoundException;
import UseCases.GetUser;

/**
 * Controller class containing options for the main menu
 * Calls different menus depending on the user's choice
 */
public class MainMenuC {

    /**
     * Constructor, taking in the user's answer on what they want to do and also their username
     * Allocates to option methods depending on the user's choice
     * @param ans the user's choice
     * @param username the user's username
     */
    public MainMenuC(String ans, String username) throws FlightNotFoundException, TicketAlreadyExistsException, TicketNotFoundException {
        switch (ans) {
            case "1":
                this.flightMenuOption();
                break;
            case "2":
                this.cancelMenuOption();
                break;
            case "3":
                this.accountInfoOption(username);
                break;
            default:
                this.exit();
                break;
        }
    }

    /**
     * First option method: directs user to the flight menu
     */
    public void flightMenuOption() throws FlightNotFoundException, TicketAlreadyExistsException {
        new FlightMenu();
    }
    /**
     * Second option method: directs user to the cancel menu
     */
    public void cancelMenuOption() throws TicketNotFoundException {
        CancelMenu.CancelMenuPrompt();
    }
    /**
     * Third option method: formats and displays the user's stored information
     * Takes in the user's username, retrieves their data from GetUser Use Case class
     * @param username the user's username
     */
    public void accountInfoOption(String username){
        String[] userdata = GetUser.ReturnUser(username).toString().split(",");

        System.out.println("Username: " + userdata[0] + "\nPassword: " + userdata[1] + "\nBirthday: " + userdata[2] +
                "/" + userdata[3] + "/" + userdata[4] + "\nEmail: " + userdata[5] + "\nMember" +
                " Status: " + userdata[6] + "\nAddress: " + userdata[7] + "\nLogin dates: " + userdata[8] + "\n" +
                "Admin: " + userdata[9]);
    }
    /**
     * Exit option: displays a message.
     */
    public void exit(){
        System.out.println("Program is closing...");
    }
}
