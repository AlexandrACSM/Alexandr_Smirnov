package ru.job4j.services.user;

import ru.job4j.services.AbstractSqlService;
import ru.job4j.sql.SqlConnectionFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author Aleksandr Smirnov.
 */
public class SqlUserServices extends AbstractSqlService implements UserServices {


    public SqlUserServices(SqlConnectionFactory factory) {
        super(factory);
    }

    public boolean createUser(User user) {
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{call sp_user_create(?,?,?,?)}");) {
            statement.setString("_name", user.getName());
            statement.setString("_email", user.getEmail());
            statement.setString("_login", user.getLogin());
            statement.setTimestamp("_date", user.getCreateDate());
            statement.registerOutParameter("_user_id", Types.BIGINT);
            if (statement.executeUpdate() > 0) {
                user.setUserId(statement.getLong("_user_id"));
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
