package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConfiguration {

    public static String createConfigurationModel(Connection connection, Map<String, String> data) {
        String message = "";
        String sql = "INSERT INTO user_configuration (user_id, time_exposition, skin, disease, api_notification)"
                + "VALUES (?,?,?,?,?)";

        try {
            int user_id = Integer.valueOf(data.get("user_id"));
            int time_exposition = Integer.valueOf(data.get("time_exposition"));
            String skin = data.get("skin");
            String disease = data.get("disease");
            int api_notification = Integer.valueOf(data.get("api_notification"));
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setInt(2, time_exposition);
            statement.setString(3, skin);
            statement.setString(4, disease);
            statement.setInt(5, api_notification);

            statement.executeUpdate();
            message = "success_config";

        } catch (SQLException ex) {
            System.out.println(ex);
            message = "sql_query_error";
        }
        return message;
    }

    public static List<Map<String, Object>> getConfiguration(Connection connection, int user_id) {
        List<Map<String, Object>> configData = new ArrayList<>();
        String sql = "SELECT * FROM user_configuration WHERE user_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> data = new HashMap<>();
                data.put("id", resultSet.getInt("id"));
                data.put("user_id", resultSet.getInt("user_id"));
                data.put("time_exposition", resultSet.getInt("time_exposition"));
                data.put("skin", resultSet.getString("skin"));
                data.put("disease", resultSet.getString("disease"));
                data.put("api_notification", resultSet.getInt("api_notification"));
                configData.add(data);
            }
            return configData;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static String updateConfiguration(Connection connection, Map<String, String> data) {
        String message = "";
        String sql = "UPDATE user_configuration SET time_exposition = ?,"
                + "skin = ?, disease = ?, api_notification = ? WHERE user_id = ?";

        try {
            int time_exposition = Integer.valueOf(data.get("time_exposition"));
            int api_notification = Integer.valueOf(data.get("api_notification"));
            int user_id = Integer.valueOf(data.get("user_id"));
            String disease = data.get("disease");
            String skin = data.get("skin");

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, time_exposition);
            statement.setString(2, skin);
            statement.setString(3, disease);
            statement.setInt(4, api_notification);
            statement.setInt(5, user_id);
            statement.executeUpdate();
            message = "success_update";
        } catch (SQLException ex) {
            message = "sql_query_error";
        }
        return message;
    }

    public static String validateConfiguration(Connection connection, int user_id) {
        String message = "";
        String sql = "SELECT * FROM user_configuration WHERE user_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            message = (resultSet.next()) ? "success" : "no_info";
        } catch (SQLException ex) {
            message = "sql_query_error";
        }
        return message;
    }
}
