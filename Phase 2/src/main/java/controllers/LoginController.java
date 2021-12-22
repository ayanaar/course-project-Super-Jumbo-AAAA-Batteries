package controllers;

import use_cases.LoginUseCase;
import gateway.LoginInputBoundary;


/**
 * Controls the process for logging in.
 */
public class LoginController {

    /**
     * The input boundary for the login use case.
     */
    private final LoginInputBoundary loginInputBoundary;

    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     * @param loginInputBoundary the input boundary for the login use case
     */
    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    /**
     * Run the login use case where username is attempting to log into their
     * account with a password attempt.
     * @param username the username
     * @param password the password attempt
     */
    public String[] runLogin(String username, String password) {
        // Note: hands off the work to the use case class.
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(username, password);
        String[] array = new String[2];
        switch (result) {
            case SUCCESS:
                array = new String[] {username, "Success"};
                return array;
            case FAILURE:
                array = new String[] {username, "Failed"};
                return array;
        }
        return array;
    }

    public static void addingUser(String username, String password) {
        LoginUseCase.addUser(username, password);
    }

    public static void loadingUserList() {LoginUseCase.loadUserList();}

    public static LoginUseCase creatingUseCase() {
        return new LoginUseCase();
    }
}
