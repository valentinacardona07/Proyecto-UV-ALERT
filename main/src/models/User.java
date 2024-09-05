package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class User {

    public static String create(Connection connection, Map<String, String> data) {
        String message = "";
        String sql = "INSERT INTO users (age, name, last_name,"
                + " email, password) VALUES (?,?,?,?,?)";

        try {
            int age = Integer.valueOf(data.get("age"));
            String name = data.get("name");
            String last_name = data.get("last_name");
            String email = data.get("email");
            String password = data.get("password");

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, age);
            statement.setString(2, name);
            statement.setString(3, last_name);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.executeUpdate();
            message = "success_registry";

        } catch (SQLException ex) {
            System.out.println(ex);
            message = "sql_query_error";
        }
        return message;
    }

    public static Map<String, Object> getUser(Connection connection, int user_id) {
        Map<String, Object> userData = new HashMap<>();
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                userData.put("id", resultSet.getInt("id"));
                userData.put("age", resultSet.getInt("age"));
                userData.put("name", resultSet.getString("name"));
                userData.put("last_name", resultSet.getString("last_name"));
                userData.put("email", resultSet.getString("email"));
                userData.put("password", resultSet.getBigDecimal("password"));
            }
            return userData;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static String update(Connection connection, Map<String, String> data) {
        String message = "";
        String sql = "UPDATE users SET age = ?, name = ?, last_name = ?, "
                + "password = ?, email = ? WHERE id = ?";

        try {
            int user_id = Integer.valueOf(data.get("user_id"));
            int age = Integer.valueOf(data.get("age"));
            String name = data.get("name");
            String last_name = data.get("last_name");
            String email = data.get("email");
            String password = data.get("password");

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, age);
            statement.setString(2, name);
            statement.setString(3, last_name);
            statement.setString(4, password);
            statement.setString(5, email);
            statement.setInt(6, user_id);
            statement.executeUpdate();
            message = "success_update";
        } catch (SQLException ex) {
            message = "sql_query_error";
        }
        return message;
    }

    public static String delete(Connection connection, int user_id) {
        String message = "";
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.executeUpdate();
            message = "success";
        } catch (SQLException ex) {
            message = "sql_query_error";
        }
        return message;
    }

    public static String validateLogin(Connection connection, String email, String password) {
        String message = "no_info";
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                message = String.valueOf(resultSet.getInt("id"));
            }

        } catch (SQLException ex) {
            message = "sql_query_error";
        }
        return message;
    }

    public static String validateUser(Connection connection, int user_id) {
        String message = "";
        String sql = "SELECT * FROM users WHERE id = ?";
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
