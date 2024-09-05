package controllers;

import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import Views.AlertView;

public class SensorService {

    private static String esp32IP;
    private static String urlStr;

    public SensorService() {
        esp32IP = "10.203.183.130/data";
        urlStr = "http://" + esp32IP;
        getData();
    }

    public String getData() {
        String uvRays = "";
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
                    uvRays = response.toString();
                    if (!uvRays.isEmpty()) {
                        System.out.println(uvRays);
                        return uvRays;
                    }
                } else {
                    uvRays = "sensor_error";
                }
            } catch (Exception e) {
                uvRays = "sensor_error";
                break;
            }
        }
        return uvRays;
    }
}
