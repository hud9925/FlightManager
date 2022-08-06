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
     * Takes the user's input from MembershipMenu. If they choose 1, they are sent to becomeMemberOption
     * which changes their member status to member and redirects them to the MembershipMenu. If they choose 2, they
     * are sent back to the MainMenu.
     * @param choice the option chosen by the user.
     * @param username the user's username.
     */
    public MembershipMenuC(int choice, String username) throws FlightNotFoundException,
            TicketAlreadyExistsException, TicketNotFoundException {
        switch (choice){
            case 1:
                this.becomeMemberOption(username);
                break;
            case 2:
                this.mainMenuOption();
                break;
        }
    }

    /**
     * -
     * @param choice the option chosen by the user.
     */
    public MembershipMenuC(int choice) throws FlightNotFoundException, TicketAlreadyExistsException,
            TicketNotFoundException {
        switch(choice){
            case 1:
                this.exclusiveFlightMenuOption();
                break;
            case 2:
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
     * Redirects user to the exclusive flight menu.
     */
    public void exclusiveFlightMenuOption(){
        System.out.println("in progress");
    }

    /**
     * Redirects user to the main menu.
     */
    public void mainMenuOption() throws FlightNotFoundException, TicketAlreadyExistsException,
            TicketNotFoundException {
        MainMenu.mainPage();
    }

    public void cancelMembershipOption() {
        System.out.println("in progress");
    }
}
