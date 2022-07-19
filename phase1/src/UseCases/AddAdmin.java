package UseCases;

import Entities.User.Admin;
import Entities.User.User;
import Entities.User.UserTracker;

/* The code below is used to add an admin User, and adds it to UserTracker
 with the new User */
public class AddAdmin {

    /**
     * Creates a new Admin instance and adds it to UserTracker.
     * @param username the admin's username
     * @param password the admin's password
     * @param birthYear the admin's birth year
     * @param birthMonth the admin's birth month
     * @param birthDay the admin's birthday
     * @param email the admin's email address
     * @param isMember the admin's membership status
     */

    public static void NewAdmin(String username, String password, int birthYear, int birthMonth, int birthDay, String email, boolean isMember){
//        Creates a new instance of admin
        User NewAdmin = new Admin(username, password, birthYear, birthMonth, birthDay, email, isMember);
        UserTracker.addUser(NewAdmin);
    }

    /**
     * Creates the first sample Admin instance and adds it to UserTracker.
     */

    public static void addFirstAdmin(){
        User firstAdmin = new Admin("Administrator", "admin123", 2000, 1, 1, "admin@sample.com", false);
        UserTracker.addUser(firstAdmin);
    }

}
