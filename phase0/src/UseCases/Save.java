package UseCases;

import Entities.User.User;
import Entities.User.UserTracker;

import java.io.PrintWriter;
import java.util.Map;

public class Save {

    public Save(PrintWriter pw){
        Map<String, User> allusers = UserTracker.getAllUsers();
        for(User user : allusers.values()){
            pw.write(user.toString() + "\n");
        }
    }
}
