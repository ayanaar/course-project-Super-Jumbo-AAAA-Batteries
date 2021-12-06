package controller;

import entities.UserList;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

import use_cases.LoginUseCase;

public class LoginControllerTest {
    LoginController controller;

    /**
     * Set up for testing LoginController class.
     */
    @Before
    public void setUp() {
        LoginController.loadingUserList();

        controller = new LoginController(LoginController.creatingUseCase());
    }

    /**
     * Test that the addingUser method correctly adds a user to the current UserList.
     */
    @Test(timeout = 100)
    public void testAddingUser() {
        UserList list = new UserList();
        LoginController.addingUser("Jennifer", "Cao");
        LoginUseCase loginUseCase = new LoginUseCase();
        assertEquals(LoginUseCase.LoginResult.SUCCESS, loginUseCase.logIn("Jennifer",
                "Cao"));
    }
}