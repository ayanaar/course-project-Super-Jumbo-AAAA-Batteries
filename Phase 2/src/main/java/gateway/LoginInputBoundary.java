package gateway;
import use_cases.LoginUseCase;


/**
 * The input boundary for the login use case.
 */
public interface LoginInputBoundary {
    LoginUseCase.LoginResult logIn(String username, String password);
}
