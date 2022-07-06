package UseCases;

import Entities.User.User;
import Entities.User.UserTracker;

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;

public class Save {

    public Save() throws IOException {
//        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Owner\\Documents\\CSC207\\grouprepository\\phase0\\UserDatabase.csv"));
        String filepath = String.valueOf(Paths.get("UserDatabase.csv").toAbsolutePath());
        PrintWriter pw = new PrintWriter(new FileWriter(filepath));
        Map<String, User> allusers = UserTracker.getAllUsers();
        for(User user : allusers.values()){
            pw.write(user.toString() + "\n");
        }
        pw.close();
    }
}
