package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:postgresql://localhost:5432/testDB";
    private static final String password = "Aluc1988";
    private static final String user = "postgres";




    public static Connection getConnection() {
        try {
            return  DriverManager.getConnection(url,
                    user,
                    password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}