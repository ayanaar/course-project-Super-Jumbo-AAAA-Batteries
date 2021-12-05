package login;
import java.util.Scanner;
import login.controller.LoginController;
import login.use_cases.LoginUseCase;
import login.controller.LoginController;

/**
 * A beautiful user interface for logging in.
 */
public class CmdLineUI {
    public void runLogin(LoginController controller) {
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        controller.runLogin(username, password);
    }

//    public void runLogin(String username, String password) {
//        // Note: hands off the work to the use case class.
//        LoginUseCase.LoginResult result = loginInputBoundary.logIn(username, password);
//        switch (result) {
//            case SUCCESS:
//                // Should we be printing? How might you refactor this program
//                // to fit the Clean Architecture?
//                // TODO: change this
//                System.out.println("Success!");
//                break;
//            case FAILURE:
//                System.out.println("Failed to login!");
//                break;
//        }
//    }
}
