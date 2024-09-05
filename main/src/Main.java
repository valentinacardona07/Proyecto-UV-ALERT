
import Views.LoginView;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import javax.swing.UIManager;
import tests.TestConnection;
import controllers.ApiService;
import tests.TestUser;
import tests.UvTest;

public class Main {

    public static void main(String[] args) {
        setupGui();
        LoginView login = new LoginView();
        login.setVisible(true);
        //test_app();
    }

    public static void setupGui() {
        try {
            FlatSolarizedLightIJTheme.setup();
            UIManager.put("Button.arc", 999);
            UIManager.put("TextComponent.arc", 999);
        } catch (Exception ex) {
            System.err.println("Error al inicializar LaF");
        }
    }

    public static void test_app() {
        TestUser.menuTest();
    }
}
