/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import controllers.UserNotificationController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UvTest {

    private static String esp32IP;
    private static String urlStr;

    public UvTest() {
        esp32IP = "192.168.10.18";
        urlStr = "http://" + esp32IP + "/";
        getData();
    }

    public void getData() {
        while (true) {
            try {
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000); // 5 segundos de tiempo de espera para la conexión
                connection.setReadTimeout(5000); // 5 segundos de tiempo de espera para la lectura

                int responseCode = connection.getResponseCode();
                if (responseCode == 200) { // HTTP OK
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    in.close();
                    readData(response.toString());
                    // System.out.println("UV Index: " + response.toString());
                } else {
                    System.out.println("Error en la conexión: " + responseCode);
                }
                break;
                // Esperar un segundo antes de la siguiente solicitud
                //Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readData(String uv_read) {
        UserNotificationController userNotification = new UserNotificationController();
        Map<String, String> data_ = new HashMap<>();
        float uv_read_float = 0;

        if (uv_read != null) {
            uv_read_float = Float.valueOf(uv_read);
            System.out.println(uv_read_float);
            if (uv_read_float >= 1.0) {
                data_.put("message", "Esta suave el dia");
                data_.put("user_id", "1");
                data_.put("date", "2024-08-08");
                userNotification.createNotification(data_);
            }
        }

    }
}
