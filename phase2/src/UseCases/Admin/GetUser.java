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
    public static User returnUser(String username){
        UserTracker ut = UserTracker.getInstance(username);
        return ut.getCurrentUser();
    }

    /**
     * Gets and returns all the current Users present in UserTracker.
     * @return all users
     */
    public String returnAllUsers(){
       StringBuilder UserLst = new StringBuilder();
       for(User user : UserTracker.getInstance()){
           UserLst.append(user.toString()).append("\n");
       }
       return UserLst.toString();
    }
}
