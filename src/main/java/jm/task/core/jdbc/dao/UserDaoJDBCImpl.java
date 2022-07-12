package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        String sql = "CREATE TABLE if not exists users (\n" +
                "    id BIGINT PRIMARY KEY ,\n" +
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

        String sql = "drop table if exists users";

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

        String sql = "insert into users (name, last_name, age) values (?, ?, ?)";

        PreparedStatement statement = null;
        try {
            statement = Util.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

        String sql = "truncate table users";

        Statement statement = Util.getStatement();

        if (statement != null){

            try {
                statement.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
