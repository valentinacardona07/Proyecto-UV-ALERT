package models;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpositionDetail {

    public static String create(Connection connection, Map<String, String> data) {
        String message = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sql = "INSERT INTO exposition_detail (user_id, uv_data, date, time )"
                + "VALUES (?,?,?,?)";

        try {
            int user_id = Integer.valueOf(data.get("user_id"));
            double uv_data = Double.valueOf(data.get("uv_data"));
            int time = Integer.valueOf(data.get("time"));
            LocalDate localDate = LocalDate.parse(data.get("date"), formatter);
            Date sqlDate = Date.valueOf(localDate);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setDouble(2, uv_data);
            statement.setDate(3, sqlDate);
            statement.setInt(4, time);
            statement.executeUpdate();
            message = "success";

        } catch (SQLException ex) {
            System.out.println(ex);
            message = "sql_query_error";
        }
        return message;
    }

    public static List<Map<String, Object>> getExposition(Connection connection, int user_id) {
        List<Map<String, Object>> expositionData = new ArrayList<>();
        String sql = "SELECT * FROM exposition_detail WHERE user_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> data = new HashMap<>();
                data.put("id", resultSet.getInt("id"));
                data.put("user_id", resultSet.getInt("user_id"));
                data.put("uv_data", resultSet.getDouble("uv_data"));
                data.put("date", resultSet.getDate("date"));
                data.put("time", resultSet.getInt("time"));
                expositionData.add(data);
            }
            return expositionData;

        } catch (SQLException ex) {
            return null;
        }
    }
}
