package UseCases.Admin;

import Entities.User.Admin;
import Entities.User.User;
import Entities.User.UserTracker;

import java.time.LocalDate;

/* The code below is used to add an admin User, and adds it to UserTracker
 * with the new User */
public class AddAdmin {

    /**
     * Creates a new Admin instance and adds it to UserTracker.
     * @param username the admin's username
     * @param password the admin's password

     * @param email the admin's email address
     */
    public static void newAdmin(String username, String password, LocalDate dob, String email){
//      Creates a new instance of admin
        User NewAdmin = new Admin(username, password, dob, email);
        UserTracker.getInstance().addUser(NewAdmin);
    }

    /**
     * Creates the first sample Admin instance and adds it to UserTracker.
     */
    public static void addFirstAdmin(){
        User firstAdmin = new Admin("Administrator", "admin123", LocalDate.of(2000, 1,
                1),  "admin@sample.com");
        UserTracker.getInstance().addUser(firstAdmin);
    }

}
