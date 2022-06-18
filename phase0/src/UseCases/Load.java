package UseCases;

import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Load {

    public Load(BufferedReader br) throws IOException, ParseException {
        String line;
        String[] userinfo;
        String[] previousdates;
        User newuser;
        while((line = br.readLine())!= null) {
            userinfo = line.split(",");
            if (userinfo[9].equals("true")){
                newuser = new Admin(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                        Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                        Boolean.parseBoolean(userinfo[6]));
            } else {
                newuser = new Customer(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                        Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                        Boolean.parseBoolean(userinfo[6]));
            }
            newuser.changeAddress(userinfo[7]);
            previousdates = userinfo[8].split("\\|");
            List<Date> datelist = new ArrayList<>();
            for(String str: previousdates){
                Date d = new SimpleDateFormat("dd/MM/yyyy").parse(str);
                datelist.add(d);
            }
            newuser.setDateList(datelist);
            UserTracker.addUser(newuser);
        }
    }
}
