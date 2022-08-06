package UseCases.Customer;

import Entities.User.Customer;
import Entities.User.UserTracker;

import java.time.LocalDate;

/* The code below is used to register a new general User
 * and adds it to UserTracker */

public class
RegisterUseCase {

    /**
     * Registers a new User based on the input parameters and saves it to
     * UserTracker. If the username is already associated with a user in UserTracker,
     * the user is not added again.
     * @param Username username of the new user
     * @param Password password of the new user
     * @param Email email address of the new user
     * @return the new user
     */
    public static boolean newUser(String Username, String Password, LocalDate dob, String Email){
//      Checks if username or email exists in UserTracker
        if (UserTracker.getInstance(Username).userExists()){
            return false;
        } else {
//          User does not exist. Register as new user.
            Customer newUser = new Customer(Username, Password, dob, Email, false);
            newUser.updateDateList();
            UserTracker.getInstance().addUser(newUser);
            return true;
        }
    }
}
