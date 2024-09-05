package tests;

import controllers.DatabaseConnector;
import java.sql.Connection;

public class TestConnection {

    public TestConnection() {
        DatabaseConnector connection_ = new DatabaseConnector();
        Connection connection = connection_.getConnection();

        if (connection != null) {
            System.out.println("Conexion exitosa!");
        } else {
            System.out.println("Sin conexion");
        }
    }
}
