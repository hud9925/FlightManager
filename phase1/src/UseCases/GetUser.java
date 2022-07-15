package UseCases;

import Entities.User.User;
import Entities.User.UserTracker;

public class GetUser {

    public User ReturnUser(String username){
        UserTracker ut = new UserTracker(username);
        return ut.getCurrentUser();
    }

    public String ReturnAllUsers(){
       StringBuilder userlst = new StringBuilder();
       for(User user : new UserTracker()){
           userlst.append(user.toString()).append("\n");
       }
       return userlst.toString();
    }
}
