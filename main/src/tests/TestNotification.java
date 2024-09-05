package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import controllers.UserNotificationController;

public class TestNotification {

    public static void menuTest() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Crear registro");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
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

    public static void createNotification() {
        UserNotificationController userNotification = new UserNotificationController();
        Map<String, String> data = new HashMap<>();
        data.put("user_id", "1");
        data.put("date", "2024-08-01");
        data.put("message", "a cuidatese");

        String create_notification = userNotification.createNotification(data);
        System.out.println(create_notification);
    }
}
