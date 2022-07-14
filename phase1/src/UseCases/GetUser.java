package UseCases;

import Entities.User.User;
import Entities.User.UserTracker;

public class GetUser {

    public GetUser() {}

    public User ReturnUser(String username){
        UserTracker ut = new UserTracker(username);
        return ut.getCurrentUser();
    }
}
