package tests;

import controllers.UserController;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author miguel
 */
public class TestUser {

    public static void menuTest() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Crear usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    searchUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

    }

    public static void registerUser() {
        UserController user = new UserController();
        Map<String, String> data = new HashMap<>();
        data.put("age", "28");
        data.put("name", "miguel");
        data.put("last_name", "angel");
        data.put("email", "mirodriguezor@unal.edu.co");
        data.put("password", "1234");

        String create_user = user.createUser(data);
        System.out.println(create_user);
    }

    public static void searchUser() {
        UserController user = new UserController();
        Map<String, Object> data = new HashMap<>();
        int user_id = 2;
        String validate_user = user.validateUser(user_id);
        if (validate_user == "success") {
            System.out.println("Se encontro info");
            data = user.getUser(user_id);
            if (data != null) {
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ": " + value);
                }
            }

        }
    }

    public static void updateUser() {
        UserController user = new UserController();
        Map<String, String> data = new HashMap<>();
        data.put("age", "25");
        data.put("name", "miguel");
        data.put("last_name", "rodriguez");
        data.put("email", "mirodriguezor@unal.edu.co");
        data.put("password", "0000");
        data.put("user_id", "1");

        String update_user = user.updateUser(data);
        System.out.println(update_user);
    }

    public static void deleteUser() {
        UserController user = new UserController();
        String delete_user = user.deleteUser(1);
        System.out.println(delete_user);
    }

}
