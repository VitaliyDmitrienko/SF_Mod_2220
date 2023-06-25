// SkillFactory Module 22.4.

package org.example;

import java.sql.*;

public class Main7 {
    private final static String HOST = "localhost"; // сервер базы данных
    private final static String DATABASENAME = "testDB";// имя базы
    private final static String USERNAME = "postgres"; // учетная запись пользователя
    private final static String PASSWORD = "987654321"; // пароль
    static Connection connection;

    public static void main(String[] args) throws SQLException {

        //Строка для соединения с бд
        String url = "jdbc:postgresql://" + HOST + "/" + DATABASENAME + "?user=" + USERNAME + "&password=" + PASSWORD;
        try {
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            if (connection == null)
                System.err.println("Нет соединения с БД!");
            else {
                System.out.println("Соединение с БД установлено корректно");
            }

            String SQL = "ALTER TABLE test ADD userer varchar(255);";
            //Запрос на получение всех данных
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.executeUpdate();
                connection.commit();
                System.out.println("Транзакция прошла");
            }
        } catch (
//                ClassNotFoundException |
                SQLException e) {
            connection.rollback();
            System.err.println("Транзакция не прошла");
            e.printStackTrace();
        }

    }
}
