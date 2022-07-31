package UseCases.Admin;
import Entities.User.UserTracker;

// A Use Case that removes a User based on the given Username if it exists in UserTracker.
public class DeleteUser {

    /**
     * Deletes a specified user from UserTracker.
     * @param Username username of the user being deleted
     * @return the user's cancellation status
     */
    public static boolean RemoveUser(String Username){
        UserTracker ut = new UserTracker(Username);
        if (ut.userExists()){
            ut.removeCurrentUser();
            return true;
        } else {
//            User with this username does not exist
            return false;
        }
    }
}
