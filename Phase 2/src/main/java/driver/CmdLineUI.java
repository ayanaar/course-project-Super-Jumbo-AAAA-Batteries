package driver;
import java.util.Scanner;
<<<<<<< HEAD:Phase 2/src/main/java/login/CmdLineUI.java
import login.controller.LoginController;
import login.use_cases.LoginUseCase;
import login.controller.LoginController;
=======
import controller.LoginController;
>>>>>>> 18173ae8825a0a5d967074b228f174b7a3ea60e4:Phase 2/src/main/java/driver/CmdLineUI.java

/**
 * A beautiful user interface for logging in.
 */
public class CmdLineUI {
    public Object runLogin(LoginController controller) {
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        String currentUser = controller.runLogin(username, password);
        if (!currentUser.equals("")) {
            return currentUser;
        }
        return null;
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
