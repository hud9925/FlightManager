package UseCases;
import java.util.ArrayList;


import Entities.User.Customer;
import Entities.User.UserTracker;
/* The code below is used to register a new general User
 * and adds it to UserTracker*/

public class
RegisterUseCase {
    public static ArrayList<Boolean> NewUser(String Username, String Password, int Year, int Month, int Day, String Email){
        ArrayList<Boolean> NewUser = new ArrayList<>();
//      Checks if username or email exists in UserTracker
        if (new UserTracker(Username).userExists()){
//          User exists.
            NewUser.add(false);
        } else {
//          User does not exist. Register as new user.
            NewUser.add(true);
            Customer newuser = new Customer(Username, Password, Year, Month, Day, Email, false);
            newuser.updateDateList();
            UserTracker.addUser(newuser);
        }

        return NewUser;
    }

}
