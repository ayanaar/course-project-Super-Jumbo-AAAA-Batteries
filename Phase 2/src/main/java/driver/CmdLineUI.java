package driver;
import java.util.Scanner;
import controller.LoginController;

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
}
