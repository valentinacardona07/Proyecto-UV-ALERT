package controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import models.ExpositionDetail;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpositionDetailController extends ExpositionDetail {

    public String createExposition(Map<String, String> data) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.create(connection, data);
        }
        return message;
    }

    public List<Map<String, Object>> getExposition(int user_id, String date) {
        List<Map<String, Object>> expositionData = new ArrayList<>();
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            expositionData = super.getExposition(connection, user_id);
        }
        return expositionData;
    }

    public boolean validateExposition(int user_id, String date) {
        UserConfigurationController userConfig = new UserConfigurationController();
        List<Map<String, Object>> configData = new ArrayList<>();
        int totalExposition = getTotalTimeExposition(user_id, date);
        int configExposition = 0;

        configData = userConfig.getConfiguration(user_id);

        if (totalExposition > 0 && configData != null) {
            for (Map<String, Object> config : configData) {
                configExposition = (int) config.get("time_exposition");
                if (totalExposition >= configExposition) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getTotalTimeExposition(int user_id, String date) {
        List<Map<String, Object>> expositionData = new ArrayList<>();
        expositionData = getExposition(user_id, date);
        int totalTimeExposition = 0;

        if (expositionData != null) {
            for (Map<String, Object> exposition : expositionData) {
                totalTimeExposition += (int) exposition.get("time");
            }
        }
        return totalTimeExposition;
    }

    public double getTotalExposition(int user_id, String date) {
        List<Map<String, Object>> expositionData = new ArrayList<>();
        expositionData = getExposition(user_id, date);
        double totalExposition = 0.0;
        int countExposition = 0;
        System.out.println("llega");
        if (expositionData != null) {
            for (Map<String, Object> exposition : expositionData) {
                totalExposition += (double) exposition.get("uv_data");
                countExposition += 1;
            }

        }
        double exposition = totalExposition / (double) countExposition;
        double roundedValue = roundToTwoDecimalPlaces(exposition);

        return roundedValue;
    }

    public double roundToTwoDecimalPlaces(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
