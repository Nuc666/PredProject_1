package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl test = new UserDaoJDBCImpl();
        test.createUsersTable();
        test.saveUser("Alexandr","F", (byte) 31);
    }
}
