package lk.apexrow.web.db;

import lk.apexrow.web.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        ApplicationProperties properties =  ApplicationProperties.getInstance();

        Class.forName(properties.get("sql.connection.driver"));

        connection = DriverManager.getConnection(properties.get("sql.connection.url"), properties.get("sql.connection.username"), properties.get("sql.connection.password"));

        return connection;
    }

    public static void iud(String query) {
        try {
            connection.createStatement().executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet search(String query) throws Exception {
        return connection.createStatement().executeQuery(query);
    }
}
