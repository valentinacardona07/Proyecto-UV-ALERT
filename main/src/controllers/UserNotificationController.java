package controllers;

import models.UserNotification;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserNotificationController extends UserNotification {

    public String createNotification(Map<String, String> data) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();
        if (connection != null) {
            message = super.createNotification(connection, data);
        }
        return message;
    }

    public List<Map<String, Object>> getAllNotification(int user_id) {
        List<Map<String, Object>> notificationData = new ArrayList<>();
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            notificationData = super.getAllNotification(connection, user_id);
        }
        return notificationData;
    }

    public List<Map<String, Object>> getNotification(int id) {
        List<Map<String, Object>> notificationData = new ArrayList<>();
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            notificationData = super.getNotification(connection, id);
        }
        return notificationData;
    }

    public void updateNotification(int id, String state) {
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            super.updateNotification(connection, id, state);
        }
    }

    public String deleteNotification(int id) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.deleteNotification(connection, id);
        }
        return message;
    }

    public String deleteAllNotification() {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.deleteAllNotification(connection);
        }
        return message;
    }

    public String getRecommendation(double uvReading, int exposureTime, int userId) {
        UserConfigurationController userConfig = new UserConfigurationController();
        List<Map<String, Object>> configData = new ArrayList<>();
        configData = userConfig.getConfiguration(userId);
        String recommendation = "";
        String disease = "";

        if (configData != null) {
            for (Map<String, Object> config : configData) {
                disease = String.valueOf(config.get("disease"));
            }
        }

        //indice 6, exposicion alta en todos los casos
        if (uvReading >= 6.0) {
            // maximo 20 min
            if (exposureTime >= 20 && disease.equals("burn")) { //buscar como ignorar mayusculas y caracteres especiales
                recommendation = "burn";
            } //maximo 15 min
            else if (exposureTime >= 15 && disease.equals("cancer")) {
                recommendation = "cancer";
            } //maximo 25 min
            else if (exposureTime >= 25 && disease.equals("aging")) {
                recommendation = "aging";
            } //maximo 8 minutos
            else if (exposureTime >= 8 && disease.equals("dermatitis")) {
                recommendation = "dermatitis";
            } //maximo 4 minutos
            else if (exposureTime >= 4 && disease.equals("lupus")) {
                recommendation = "lupus";
            } //maximo 4 minutos
            else if (exposureTime >= 4 && disease.equals("dermatosis")) {
                recommendation = "dermatosis";
            } else {
                recommendation = "general";
            }
        }
        return recommendation;

    }

    public String validateUv(Double uv_read, int userId) {
        /**
         *
         */
        UserConfigurationController userConfig = new UserConfigurationController();
        List<Map<String, Object>> configData = new ArrayList<>();
        configData = userConfig.getConfiguration(userId);
        String key = "";
        String skin = "";

        if (configData != null) {
            for (Map<String, Object> config : configData) {
                skin = String.valueOf(config.get("skin"));
            }
        }

        if (uv_read >= 10.0) {
            if (!skin.isEmpty()) {
                key = skin;
            } else {
                key = "high_level";
            }
        } else {
            key = "low_level";
        }

        return key;
    }
}
