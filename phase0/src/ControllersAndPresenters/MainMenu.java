package ControllersAndPresenters;

import Entities.User.User;
import Entities.User.UserTracker;

import java.util.Scanner;

public class MainMenu {

    public static void mainPage(String username) {

        Scanner input0 = new Scanner(System.in);
        System.out.println("Welcome to the air ticket reserving system! \n Would you like to see a history of your" +
                "login dates? Press \"Y\" for yes, any other key for no.");
        String ans = input0.next();
        if(ans.equals("Y") || ans.equals("y")){
            UserTracker ut = new UserTracker(username);
            User u1 = ut.getCurrentUser();
            System.out.println(u1.getDateList());
        } else {
            System.out.println("Temporary end of Program! Hope to see you in phase 1!");
        }
    }
}
