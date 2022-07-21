package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        String sql = "CREATE TABLE if not exists users (\n" +
                "    id SERIAL PRIMARY KEY,\n" +
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

        System.out.println( "User с именем –" + name+ " добавлен в базу данных" );


    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";

        PreparedStatement statement = null;
        try {
            statement = Util.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {

        List<User> allUsers = new ArrayList<>();

        String sql = "SELECT * FROM users";

        Statement statement = Util.getStatement();

        if (statement != null){

            try {
                statement.execute(sql);
                ResultSet rs = statement.executeQuery(sql);
                int i = 0;
                while (rs.next()){
                    User opUser = new User();
                    opUser.setId(rs.getLong(1));
                    opUser.setName(rs.getString(2));
                    opUser.setLastName(rs.getString(3));
                    opUser.setAge(rs.getByte(4));
                    allUsers.add(i, opUser);
                    i++;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return allUsers;

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
