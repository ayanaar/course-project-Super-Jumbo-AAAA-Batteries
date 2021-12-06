package driver;
import java.util.Scanner;
import controllers.LoginController;

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
        String[] currentUser = new String[2];
        currentUser = controller.runLogin(username, password);
        if (currentUser[1].equals("Failed")) {
            System.out.println("Login Failed");
            System.exit(0);
        }
        if (!currentUser[0].equals("")) {
            return currentUser[0];
        }
        return null;
    }
}
