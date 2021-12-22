package use_cases;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the LoginUseCase class.
 */
public class LoginUseCaseTest {
    LoginUseCase loginUseCase;

    /**
     * Set up for testing LoginUseCase class.
     */
    @Before
    public void setUp() {
        loginUseCase = new LoginUseCase();
    }

    /**
     * Test that the addUser() method adds the user to the system.
     */
    @Test(timeout = 100)
    public void testAddUser() {
        LoginUseCase.addUser("Nada", "Eldin");
        assertEquals(LoginUseCase.LoginResult.SUCCESS,
                loginUseCase.logIn("Nada", "Eldin"));
    }

    /**
     * Test that the logIn() method fails.
     */
    @Test(timeout = 100)
    public void testLogIn() {
        assertEquals(LoginUseCase.LoginResult.FAILURE,
                loginUseCase.logIn("Nada", "Bird"));
    }
}

