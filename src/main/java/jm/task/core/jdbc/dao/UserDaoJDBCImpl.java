package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        String sql = "CREATE TABLE users (\n" +
                "    id BIGINT PRIMARY KEY,\n" +
                "    name VARCHAR(50),\n" +
                "    last_name VARCHAR(50),\n" +
                "    age SMALLINT);";

        Statement statement = Util.getStatement();

        if (statement != null){

            try {
                statement.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void dropUsersTable() {

        String sql = "drop table users";

        Statement statement = Util.getStatement();

        if (statement != null){

            try {
                statement.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
