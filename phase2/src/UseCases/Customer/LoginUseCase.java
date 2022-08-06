package UseCases.Customer;
import java.util.ArrayList;
import java.util.Objects;

import Entities.User.User;
import Entities.User.UserTracker;

/* A Use Case that handles checking whether the User trying to
 * log in exists and determines whether they are a Customer or an Admin. */

public class LoginUseCase {

    /**
     * Checks whether the username and password match the login details
     * of an existing user in UserTracker and returns whether they are
     * an Admin or Customer.
     * @param Username username of the user logging in
     * @param password password of the user logging in
     * @return if the username exists, whether it is an admin or customer user
     */
    public static ArrayList<Boolean> userType(String Username, String password){
//      Checking if the Username belongs to a User within UserTracker
        ArrayList<Boolean> Usertype = new ArrayList<>(2);
        UserTracker ut = UserTracker.getInstance(Username);
        if (ut.userExists()){
//      User exists with the Username
            User user = ut.getCurrentUser();
//      Checking if the password matches
            if (Objects.equals(user.getPassword(), password)){
                Usertype.add(true);
//                Updates pre-existing User(login date/times)
                user.updateDateList();
                // Checks if User is an Admin
                if (user.isAdmin()){
//                  User is an admin, returns [true, true]
                    Usertype.add(true);
                } else{
//                  User is not an admin, Returns [true, false]
                    Usertype.add(false);
                }
            } else{
//                incorrect password; will not access User information
                Usertype.add(false);
                Usertype.add(false);
            }
        } else {
            //User does not exist;
            Usertype.add(false);
            Usertype.add(false);
        }
       return Usertype;
    }
}
