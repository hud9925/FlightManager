package UseCases.Customer;

import Entities.User.Customer;
import Entities.User.UserTracker;

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
     * @param Year birth year of the new user
     * @param Month birth month of the new user
     * @param Day birthday of the new user
     * @param Email email address of the new user
     * @return the new user
     */
    public static boolean NewUser(String Username, String Password, int Year, int Month, int Day, String Email){
//      Checks if username or email exists in UserTracker
        if (new UserTracker(Username).userExists()){
            return false;
        } else {
//          User does not exist. Register as new user.
            Customer newUser = new Customer(Username, Password, Year, Month, Day, Email, false);
            newUser.updateDateList();
            UserTracker.addUser(newUser);
            return true;
        }
    }
}
