package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl test = new UserDaoJDBCImpl();
        test.createUsersTable();

        test.saveUser("Ivan", "Ivanov", (byte)6);
        test.saveUser("Ivan", "Sidorov", (byte)7);
        test.saveUser("Petr", "Ivanov", (byte)6);
        test.saveUser("Sidr", "Petrov", (byte)9);

        test.getAllUsers().forEach(x -> System.out.println(x.toString()));

        test.cleanUsersTable();

        test.dropUsersTable();

    }
}
