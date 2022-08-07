package CustomerUseCaseTests;

import UseCases.Admin.AddAdmin;
import UseCases.Customer.LoginUseCase;
import UseCases.Customer.RegisterUseCase;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests for UseCases that handle logging and registering Users
 */
public class LoginAndRegisterTests {
    @Test(timeout = 50)
    public void testLoginUseCase(){
        AddAdmin.newAdmin("someone", "probably",  LocalDate.of(2000,10,20),
                "amy");
        ArrayList<Boolean> Predicates = new ArrayList<>();
        Predicates.add(true);
        Predicates.add(true);
        assertEquals(Predicates, LoginUseCase.userType("someone", "probably"));
    }
    @Test(timeout = 50)
    public void testRegisterUseCase(){
        assertTrue(RegisterUseCase.newUser("C1", "P1", LocalDate.of(1111, 12, 21)
                , "ma214"));
        assertFalse(RegisterUseCase.newUser("C1", "P1", LocalDate.of(1111, 12, 21)
                , "ma214"));
    }
}
