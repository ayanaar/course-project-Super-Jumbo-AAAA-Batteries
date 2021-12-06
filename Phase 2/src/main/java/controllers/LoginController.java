package controllers;

import use_cases.LoginUseCase;
import gateway.LoginInputBoundary;

/**
 * Controls the process for logging in.
 */
// If we handled logging out as well, this would be a good controller
// to do it in. It could have runLogin and runLogout methods.
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
                // TODO: change this
//                System.out.println("Success! Welcome, " + username + "!")
                array = new String[] {username, "Success"};
                return array;
            case FAILURE:
//                System.out.println("Failed to login!");
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
