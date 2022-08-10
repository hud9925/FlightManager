package UseCases.Admin;

import Entities.User.Customer;
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
     * Used for returning a customer with the input username
     * @param username username of the customer
     * @return the customer
     */
    public static Customer returnCustomer(String username){
        UserTracker ut = UserTracker.getInstance(username);
        return (Customer)ut.getCurrentUser();
    }

    /**
     * Gets and returns all the current Users present in UserTracker.
     * @return all users
     */
    public static String returnAllUsers(){
       StringBuilder UserLst = new StringBuilder();
       for(User user : UserTracker.getInstance()){
           UserLst.append(user.toString()).append("\n");
       }
       return UserLst.toString();
    }
}
