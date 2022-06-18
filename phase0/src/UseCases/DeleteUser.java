package UseCases;
import Entities.User.UserTracker;

// Removes a User with the given Username in Usertracker
public class DeleteUser {
    public void RemoveUser(String Username){
        UserTracker.removeUser(Username);
        }
    }
