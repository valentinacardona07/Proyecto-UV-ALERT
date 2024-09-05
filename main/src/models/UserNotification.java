package models;

import controllers.DatabaseConnector;
import controllers.UserController;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserNotification {

    public static String createNotification(Connection connection, Map<String, String> data) {
        String message = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sql = "INSERT INTO user_notifications (user_id, date, message, state)"
                + "VALUES (?,?,?,?)";

        try {
            int user_id = Integer.valueOf(data.get("user_id"));
            String dateStr = data.get("date");
            String state = data.get("state");
            LocalDate localDate = LocalDate.parse(dateStr, formatter);

            Date sqlDate = Date.valueOf(localDate);
            String text_noitification = data.get("message");

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setDate(2, sqlDate);
            statement.setString(3, text_noitification);
            statement.setString(4, state);
            statement.executeUpdate();
            message = "success";

        } catch (SQLException ex) {
            ex.printStackTrace();
            message = "sql_query_error";
        }
        return message;
    }

    public static List<Map<String, Object>> getAllNotification(Connection connection, int user_id) {
        List<Map<String, Object>> notificationData = new ArrayList<>();
        String sql = "SELECT * FROM user_notifications WHERE user_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> data = new HashMap<>();
                data.put("id", resultSet.getInt("id"));
                data.put("user_id", resultSet.getInt("user_id"));
                data.put("date", resultSet.getDate("date"));
                data.put("message", resultSet.getString("message"));
                data.put("state", resultSet.getString("state"));
                notificationData.add(data);
            }
            return notificationData;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<Map<String, Object>> getNotification(Connection connection, int id) {
        List<Map<String, Object>> notificationData = new ArrayList<>();
        String sql = "SELECT * FROM user_notifications WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> data = new HashMap<>();
                data.put("id", resultSet.getInt("id"));
                data.put("user_id", resultSet.getInt("user_id"));
                data.put("date", resultSet.getDate("date"));
                data.put("message", resultSet.getString("message"));
                notificationData.add(data);
            }
            return notificationData;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String updateNotification(Connection connection, int id, String state) {
        String message = "";
        String sql = "UPDATE user_notifications SET state = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, state);
            statement.setInt(2, id);
            statement.executeUpdate();
            message = "success_update";
        } catch (SQLException ex) {
            message = "sql_query_error";
        }
        return message;
    }

    public static String deleteNotification(Connection connection, int id) {
        String message = "";
        String sql = "DELETE FROM user_notifications WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            message = "success_delete";
        } catch (SQLException ex) {
            ex.printStackTrace();
            message = "sql_query_error";
        }
        return message;
    }

    public static String deleteAllNotification(Connection connection) {
        String message = "";
        String sql = "DELETE FROM user_notifications";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            message = "success_delete_all";
        } catch (SQLException ex) {
            ex.printStackTrace();
            message = "sql_query_error";
        }
        return message;
    }
}
