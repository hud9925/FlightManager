package UseCases;

import Entities.User.User;
import Entities.User.UserTracker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Save {

    public Save(PrintWriter pw) throws IOException{
        Map<String, User> allusers = UserTracker.getAllUsers();
        String towrite = allusers.toString();
        pw.write(towrite);
    }
}
