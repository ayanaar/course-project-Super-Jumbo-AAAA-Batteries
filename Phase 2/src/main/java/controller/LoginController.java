package controller;

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
    public String runLogin(String username, String password) {
        // Note: hands off the work to the use case class.
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(username, password);
        switch (result) {
            case SUCCESS:
                // Should we be printing? How might you refactor this program
                // to fit the Clean Architecture?
                // TODO: change this
                System.out.println("Success! Welcome, " + username + "!");
                return username;
            case FAILURE:
                System.out.println("Failed to login!");
                return "";
        }
        return null;
    }

    public static void addingUser(String username, String password) {
        LoginUseCase.addUser(username, password);
    }

    public static void creatingUserList() {
        LoginUseCase.newUserList();
    }

    public static void loadingUserList() {LoginUseCase.loadUserList();}

    public static LoginUseCase creatingUseCase() {
        LoginUseCase useCase = new LoginUseCase();
        return useCase;
    }
}
