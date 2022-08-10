package CustomerUseCaseTests;

import Entities.User.Customer;
import Entities.User.UserTracker;
import UseCases.Customer.PaymentManager;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Tests For UseCase PaymentManager of Package Customer
 */
public class PaymentManagerTests {
    @Test(timeout = 200)
    public void testcreatePaymentMethod() {
        Customer c1 = new Customer("apple", "banana", LocalDate.now(), "Apple@gmail.com", false);
        UserTracker.getInstance().addUser(c1);
        PaymentManager.createPaymentMethod("apple", 4500567, "3478");
        assertEquals(4500567, c1.getPaymentMethod().getCardNumber());
    }
    @Test(timeout = 50)
    public void testDepositMethod() {
        Customer c1 = new Customer("apple", "banana", LocalDate.now(), "Apple@gmail.com", false);
        UserTracker.getInstance().addUser(c1);
        PaymentManager.deposit("apple", 60);
        assertEquals(60, c1.getPaymentMethod().getBalance());
    }
    @Test(timeout = 50)
    public void testPurchaseMethod() {
        Customer c1 = new Customer("apple", "banana", LocalDate.now(), "Apple@gmail.com", false);
        UserTracker.getInstance().addUser(c1);
        PaymentManager.deposit("apple", 60);
        assertEquals(30, PaymentManager.purchase("apple", 30));
    }
    @Test(timeout = 200)
    public void testAccountDetails() {
        Customer c1 = new Customer("apple", "banana", LocalDate.now(), "Apple@gmail.com", false);
        UserTracker.getInstance().addUser(c1);
        PaymentManager.createPaymentMethod("apple", 4500567, "3478");
        PaymentManager.deposit("apple", 60);
        assertEquals(PaymentManager.accountDetails("apple"), "Your Card Number:4500567\n" +
                                                                            "Your Balance: 60");
    }
}
