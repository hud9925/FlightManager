package Controllers;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import Presenters.Customer.MainMenu;
import Presenters.Customer.MembershipMenu;
import UseCases.FlightNotFoundException;
import UseCases.Admin.GetUser;

/**
 * Controller for the MembershipMenu presenter class that handles the options for non-member customers
 * and redirects them accordingly.
 */
public class MembershipMenuC {

    /**
     * Takes the user's input from MembershipMenu. If they enter 'yes', they become a member. Any other combination
     * of characters will return them to the Main Menu.
     * @param choice the option chosen by the user.
     * @param username the user's username.
     */
    public MembershipMenuC(String choice, String username) throws FlightNotFoundException,
            TicketAlreadyExistsException, TicketNotFoundException {
        switch(choice){
            case "1":
                this.cancelMembershipOption(username);
                break;
            case "2":
                this.becomeMemberOption(username);
                break;
            default:
                this.mainMenuOption();
                break;
        }
    }

    /**
     * Changes the user's membership status to member and redirects them to MembershipMenu.
     * @param username the user's username.
     */
    public void becomeMemberOption(String username) throws FlightNotFoundException, TicketAlreadyExistsException,
            TicketNotFoundException {
        GetUser.returnUser(username).changeMemberStatus(true);
        System.out.println("Congratulations, you are now a member!");
        MembershipMenu.membershipMenuPrompt();
    }

    /**
     * Redirects user to the main menu.
     */
    public void mainMenuOption() throws FlightNotFoundException, TicketAlreadyExistsException,
            TicketNotFoundException {
        MainMenu.mainPage();
    }

    /**
     * Changes the user's membership status to member and redirects them to the Main Menu.
     * @param username the user's username.
     */
    public void cancelMembershipOption(String username) throws FlightNotFoundException,
            TicketAlreadyExistsException, TicketNotFoundException {
        GetUser.returnUser(username).changeMemberStatus(false);
        System.out.println("You are no longer a member!");
        MainMenu.mainPage();
    }
}
