package CustomerUseCaseTests;
import Entities.User.Customer;

import Entities.User.UserTracker;
import UseCases.Customer.SeeAccountDetails;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Test for UseCase SeeAccountDetails
 */
public class AccountDetailsTest {

    @Test(timeout = 200)
    public void testAccountDetails(){
        Customer c1 = new Customer("apple", "banana",LocalDate.now(), "Apple@gmail.com", false);
        assertEquals("User does not exist", SeeAccountDetails.accountDetails("apple"));
        UserTracker.getInstance().addUser(c1);
        assertEquals("apple,banana,2022-08-10,Apple@gmail.com,false,,false,0", SeeAccountDetails.accountDetails("apple"));
    }

}
