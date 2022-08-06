package UseCases.Customer;

import Entities.User.UserTracker;

// UseCase that returns a User's account details.

public class SeeAccountDetails {

    /**
     * Parses the specified User in UserTracker and returns a
     * string overview of their account details.
     * @param username the user's username
     * @return the user's account details
     */
    public static String accountDetails(String username){
        UserTracker usertracker = UserTracker.getInstance(username);
        if (usertracker.userExists()){
            return usertracker.getCurrentUser().toString();

        } else {
            return "User does not exist";
        }
    }
}
