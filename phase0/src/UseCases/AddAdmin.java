package UseCases;

import Entities.User.Admin;
import Entities.User.UserTracker;

/* The code below is used to add an admin User, and adds it to Usertracker
 with the new User */
public class AddAdmin {
    public static void NewAdmin(String username, String password, int birthYear, int birthMonth, int birthDay, String email, boolean isMember){
//        Creates a new instance of admin
        Admin NewAdmin = new Admin(username, password, birthYear, birthMonth, birthDay, email, isMember);
        UserTracker.addUser(NewAdmin);
    }

}
