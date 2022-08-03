package UseCases.Admin;

import Entities.User.User;
import Entities.User.UserTracker;

// A Use Case containing methods to parse a specific user/category of users.

public class GetUser {

    /**
     * Gets and returns the User associated with the input username.
     * @param username username of the User to parse
     * @return the User
     */
    public static User ReturnUser(String username){
        UserTracker ut = new UserTracker(username);
        return ut.getCurrentUser();
    }

    /**
     * Gets and returns all the current Users present in UserTracker.
     * @return all users
     */
    public String ReturnAllUsers(){
       StringBuilder UserLst = new StringBuilder();
       for(User user : new UserTracker()){
           UserLst.append(user.toString()).append("\n");
       }
       return UserLst.toString();
    }
}
