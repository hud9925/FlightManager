package UseCases;
import Entities.User.UserTracker;

// Removes a User with the given Username in Usertracker
public class DeleteUser {
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
