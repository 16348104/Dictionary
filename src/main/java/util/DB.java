package util;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class DB {

    private static final String URL = "jdbc:mysql:///test";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                new Driver();
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
