package login;
import java.util.Scanner;
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
}
