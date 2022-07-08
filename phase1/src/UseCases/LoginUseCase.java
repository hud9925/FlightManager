package UseCases;
import java.util.ArrayList;
import java.util.Objects;

import Entities.User.User;
import Entities.User.UserTracker;
public class LoginUseCase {

    public static ArrayList<Boolean> UserType(String Username, String password){
//      Checking if the Username belongs to a User within UserTracker
        ArrayList<Boolean> Usertype = new ArrayList<>(2);
        UserTracker ut = new UserTracker(Username);
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
//                incorrect password; wont access User information
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
