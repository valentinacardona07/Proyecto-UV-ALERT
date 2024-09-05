package controllers;

import models.UserConfiguration;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class UserConfigurationController extends UserConfiguration {

    public String createConfiguration(Map<String, String> data) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();
        if (connection != null) {
            message = super.createConfigurationModel(connection, data);
        }
        return message;
    }

    public List<Map<String, Object>> getConfiguration(int userId) {
        List<Map<String, Object>> configData = new ArrayList<>();
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            configData = super.getConfiguration(connection, userId);
        }
        return configData;
    }

    public String updateConfiguration(Map<String, String> data) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.updateConfiguration(connection, data);
        }
        return message;
    }

    public String validateConfiguration(int userId) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.validateConfiguration(connection, userId);
        }
        return message;
    }

    public boolean validateApiNotification(int userId) {
        List<Map<String, Object>> configData = new ArrayList<>();
        boolean apiNotification = false;
        String apiNotification_ = "";
        configData = getConfiguration(userId);
        if (configData != null) {
            for (Map<String, Object> config : configData) {
                apiNotification_ = String.valueOf(config.get("api_notification"));
                if (apiNotification_.equals("1")) {
                    apiNotification = true;
                }
            }
        }
        return apiNotification;
    }

}
