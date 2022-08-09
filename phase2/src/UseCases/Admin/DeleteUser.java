package UseCases.Admin;
import Entities.User.User;
import Entities.User.UserTracker;

// A Use Case that removes a User based on the given Username if it exists in UserTracker.
public class DeleteUser {

    /**
     * Deletes a specified user from UserTracker.
     * @param Username username of the user being deleted
     * @return the user's cancellation status
     */
    public static boolean removeUser(String Username){
        UserTracker ut = UserTracker.getInstance(Username);
        if (ut.userExists()){
            ut.removeCurrentUser();
            return true;
        } else {
//            User with this username does not exist
            return false;
        }
    }
    /**
     * Deletes all Users Inside UserTracker
     */
    public static void ClearAllUsers(String username){
        User currentUser = GetUser.returnUser(username);
        UserTracker.getInstance().removeAllUsers();
        UserTracker.getInstance().addUser(currentUser);
    }
}
