package lk.ijse.cmjd.fx.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;
    public static Connection getConnection() throws Exception{
        if (connection==null){
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC",
                    "root"
                    ,"1234"
            );
        }
        return connection;
    }
}
