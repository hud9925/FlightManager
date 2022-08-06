package Controllers;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import Presenters.Customer.MainMenu;
import Presenters.Customer.MembershipMenu;
import UseCases.FlightNotFoundException;
import UseCases.Admin.GetUser;

public class MembershipMenuC {

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

    public void becomeMemberOption(String username) throws FlightNotFoundException, TicketAlreadyExistsException,
            TicketNotFoundException {
        GetUser.returnUser(username).changeMemberStatus(true);
        System.out.println("Congratulations, you are now a member!");
        MembershipMenu.membershipMenuPrompt();

    }

    public void mainMenuOption() throws FlightNotFoundException, TicketAlreadyExistsException, TicketNotFoundException {
        MainMenu.mainPage();
    }

}

