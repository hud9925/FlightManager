import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;
import UseCases.AddAdmin;
import UseCases.Load;
import UseCases.Save;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class TestSuite {

    public void setup() throws IOException, ParseException {
        new Load();
        User u1 = new Customer("bob", "pool", 2003, 07, 06, "bruh", false);
        Customer c1 = new Customer("Dad", "ball", 1900, 02, 03, "none", true);
        User u2 = new Admin("pablo", "mod", 2010, 03, 04, "dis", false);
        Admin a1 = new Admin("Who", "idk", 1111, 01, 01, "plank", true);

        UserTracker.addUser(u1);
        UserTracker.addUser(c1);
        UserTracker.addUser(u2);
        UserTracker.addUser(a1);

        new Save();
    }
    @Test(timeout = 50)
    public void testAddFirstAdmin(){
        AddAdmin.addFirstAdmin();
        System.out.println(UserTracker.getTotalUserCount());

        assertEquals(UserTracker.getTotalUserCount(),2);

        UserTracker ut2 = new UserTracker("someone");
        UserTracker ut3 = new UserTracker("Administrator");
        assertTrue(ut2.userExists());
        assertTrue(ut3.userExists());
    }
    @Test(timeout = 50)
    public void testAddNewAdmin(){
        AddAdmin.NewAdmin("someone", "probably", 2111, 12, 31, "amy", false);
        assertEquals(UserTracker.getTotalUserCount(),1);

        UserTracker ut3 = new UserTracker("someone");
        UserTracker ut4 = new UserTracker("Administrator");
        assertTrue(ut3.userExists());
        assertFalse(ut4.userExists());
    }
}
