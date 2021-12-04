package driver;

import controller.LoginController;
import driver.CmdLineUI;

import java.util.Objects;

public class LogInSystem {

    public static String logInSys() {

        LoginController.loadingUserList();
        LoginController controller = new LoginController(LoginController.creatingUseCase());; //controller
        CmdLineUI ui = new CmdLineUI(); //UI
        Object currentUser = ui.runLogin(controller);
        if (Objects.nonNull(currentUser)){
            return (String) currentUser;
        }
        return "";
    }
}
