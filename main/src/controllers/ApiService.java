package controllers;

import java.util.concurrent.atomic.AtomicReference;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.io.IOException;
import org.json.JSONObject;
import java.net.URI;

public class ApiService {

    private static final AtomicReference<UvDataTemplate> latestData = new AtomicReference<>();
    private static String apiKey = "c3373927087c82cd7922f39b67ee7216";
    private static double longitude = -74.08175;
    private static double latitude = 4.60971;

    public static void buildData() {
        try {
            String uvData = getUvData(); // obtiene los datos en formato json y los almacena en el objeto
            String weatherData = getWeatherData();
            JSONObject uvJson = new JSONObject(uvData); // se crea un objeto json para extraer los datos de indice uv y fecha
            JSONObject weatherJson = new JSONObject(weatherData);
            System.out.println(weatherJson);
            String date = uvJson.getString("date_iso");
            double uvIndex = uvJson.getDouble("value");
            double temperature = weatherJson.getJSONObject("main").getDouble("temp");
            double humidity = weatherJson.getJSONObject("main").getDouble("humidity");
            double pressure = weatherJson.getJSONObject("main").getDouble("pressure");
            double feelsLike = weatherJson.getJSONObject("main").getDouble("feels_like");
            double tempMin = weatherJson.getJSONObject("main").getDouble("temp_min");
            double tempMax = weatherJson.getJSONObject("main").getDouble("temp_max");
            double cloudCover = weatherJson.getJSONObject("clouds").getDouble("all");
            String cityName = weatherJson.getString("name");
            String description = weatherJson.getJSONArray("weather").getJSONObject(0).getString("description");

            UvDataTemplate data = new UvDataTemplate(date, uvIndex, temperature, humidity, pressure, description, feelsLike, tempMin, tempMax, cloudCover, cityName);
            latestData.set(data);

        } catch (IOException | InterruptedException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    public static UvDataTemplate getLatestData() {
        //Funcion de tipo UvData, solo retorna dicho tipo.
        return latestData.get();
    }

    public static String getUvData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/uvi?lat=" + latitude + "&lon=" + longitude + "&appid=" + apiKey))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getWeatherData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + apiKey + "&units=metric"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static class UvDataTemplate {

        private final String date;
        private final double uvIndex;
        private final double temperature;
        private final double humidity;
        private final double pressure;
        private final String description;
        private final double feelsLike;
        private final double tempMin;
        private final double tempMax;
        private final double cloudCover;
        private final String cityName;

        public UvDataTemplate(String date, double uvIndex, double temperature, double humidity, double pressure, String description, double feelsLike, double tempMin, double tempMax, double cloudCover, String cityName) {
            this.date = date;
            this.uvIndex = uvIndex;
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            this.description = description;
            this.feelsLike = feelsLike;
            this.cityName = cityName;
            this.cloudCover = cloudCover;
            this.tempMax = tempMax;
            this.tempMin = tempMin;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public double getTempMin() {
            return tempMin;
        }

        public double getTempMax() {
            return tempMax;
        }

        public double getCloudCover() {
            return cloudCover;
        }

        public String getCityName() {
            return cityName;
        }

        public String getDate() {
            return date;
        }

        public double getUvIndex() {
            return uvIndex;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getPressure() {
            return pressure;
        }

        public String getDescription() {
            return description;
        }
    }
}
