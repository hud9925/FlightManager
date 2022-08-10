package Controllers;

import Presenters.Customer.FlightMenu;
import Presenters.Customer.MainMenu;
import Presenters.Customer.MembershipMenu;
import Presenters.Customer.PurchaseMenu;
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
    public MembershipMenuC(String choice, String username) {
        switch(choice){
            case "1":
                this.cancelMembershipOption(username);
                break;
            case "2":
                this.purchaseOption(username);
                break;
            case "3":
                this.becomeMemberOption(username);
                break;
            default:
                this.mainMenuOption(username);
                break;
        }
    }

    /**
     * Changes the user's membership status to member and redirects them to MembershipMenu.
     * @param username the user's username.
     */
    private void becomeMemberOption(String username) {
        GetUser.returnUser(username).changeMemberStatus(true);
        System.out.println("Congratulations, you are now a member!");
        MembershipMenu.membershipMenuPrompt(username);
    }

    /**
     * Redirects user to the main menu.
     *
     * @param username The username of the current user.
     */
    private void mainMenuOption(String username) {
        MainMenu.mainPage(username);
    }

    /**
     * Changes the user's membership status to member and redirects them to the Main Menu.
     * @param username the user's username.
     */
    private void cancelMembershipOption(String username) {
        GetUser.returnUser(username).changeMemberStatus(false);
        System.out.println("You are no longer a member!");
        MainMenu.mainPage(username);
    }

    /**
     * redirects member to flight menu to buy a flight
     * @param username the user's username
     */
    private void purchaseOption(String username){
        FlightMenu.flightMenuPrompt(username);
    }
}
