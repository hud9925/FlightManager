package UseCases;
import Entities.User.UserTracker;

// Removes a User with the given Username in Usertracker
public class DeleteUser {
    public static boolean RemoveUser(String Username){
        if (UserTracker.getAllUsers().get(Username)==null){
//            User with this username does not exist
            return false;
        } else {
            UserTracker.removeUser(Username);
            return true;
        }
    }
}
