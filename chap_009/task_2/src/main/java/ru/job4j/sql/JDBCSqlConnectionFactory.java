package ru.job4j.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Aleksandr Smirnov.
 */
public class JDBCSqlConnectionFactory implements SqlConnectionFactory {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/users?" +
                "users_user&password=212021");
    }
}
