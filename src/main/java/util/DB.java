package util;

import java.sql.*;
import com.mysql.jdbc.Driver;
/**
 * Created by xdx on 2015/12/11.
 */
public class DB {
    private static final String url = "jdbc:mysql:///test";
    private static final String user = "root";
    private static final String password = "1111";
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) {
            try {
                new Driver();
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void close(ResultSet result, PreparedStatement prepare) {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (prepare != null) {
            try {
                prepare.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
