package CustomerUseCaseTests;

import Entities.User.Customer;
import Entities.User.PaymentMethod;
import UseCases.Customer.PaymentManager;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PaymentManagerTests {
    @Test(timeout = 50)
    public void testcreatePaymentMethod(){
        Customer c1 = new Customer("apple", "banana", LocalDate.now(), "Apple@gmail.com", false);
        PaymentManager.createPaymentMethod("apple", 5607-793-3792, 3478);
        PaymentMethod p1 = c1.getPaymentMethod();
        assertEquals(p1.getCardNumber(), 5607-793-3792);
    }
    @Test(timeout = 50)
    public void testPaymentMethod(){}
}
