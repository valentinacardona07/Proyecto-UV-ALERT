package controllers;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import models.User;

public class UserController extends User {

    public String createUser(Map<String, String> data) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.create(connection, data);
        }
        return message;
    }

    public Map<String, Object> getUser(int user_id) {
        Map<String, Object> userData = new HashMap<>();
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            userData = super.getUser(connection, user_id);
        }
        return userData;
    }

    public String updateUser(Map<String, String> data) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.update(connection, data);
        }
        return message;
    }

    public String deleteUser(int user_id) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.delete(connection, user_id);
        }
        return message;
    }

    public String validateLogin(String email, String password) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.validateLogin(connection, email, password);
        }
        return message;
    }

    public String validateUser(int user_id) {
        String message = "";
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            message = super.validateUser(connection, user_id);
        }
        return message;
    }

}
