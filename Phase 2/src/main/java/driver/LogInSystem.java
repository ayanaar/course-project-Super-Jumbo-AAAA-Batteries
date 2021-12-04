package driver;

import controller.LoginController;
import driver.CmdLineUI;

public class LogInSystem {

    public static void logInSys() {

        LoginController.creatingUserList(); // creates list
        LoginController.addingUser("Alissa", "Lozhkin"); // adds user
        LoginController.addingUser("Jennifer", "Cao");
        LoginController.addingUser("Ali", "Eren Kaya");
        LoginController.addingUser("Ayanaa", "Rahman");
        LoginController.addingUser("Aamishi", "Avarsekar");
        LoginController.addingUser("Sam", "Shin");
        LoginController.addingUser("Deepkamal", "Kaur Gill");
        LoginController controller = new LoginController(LoginController.creatingUseCase());; //controller
        CmdLineUI ui = new CmdLineUI(); //UI
        ui.runLogin(controller);
    }
}
