package org.example;

import java.sql.*;

public class Main3 {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=987654321";

    private static String conok="Соединение с бд установлено";
    private static String conerr="Произошла ошибка подключения к бд";


    public static void main(String[] args) throws SQLException {

        try (Connection connection = DriverManager.getConnection(URL)){
            System.out.println(String.format("%s",conok));

//            String s = "SELECT * from test;";
            Statement statement = connection.createStatement();

//            String query = "SELECT userer, id, password FROM users WHERE userer='" + users.name + "' AND password = '" + users.password + "'";
//            System.out.println(query);
//            ResultSet resultSet = statement.executeQuery(query);

//            while (resultSet.next()) {
//                System.out.println("User: id=" + resultSet.getInt("id") +
//                        "name=" + resultSet.getString("user") +
//                        "password=" + resultSet.getString("password"));

            }
//            ResultSet resultSet = statement.executeQuery(sql);
//            System.out.println("ID");
//            System.out.println("||------------||");
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("ID"));
//            }
//            System.out.println("||------------||");

//            statement.close();
//            resultSet.close();
//            connection.close();

//        }
        catch (SQLException e) {
            System.out.println(String.format("%s",conerr));
//            e.printStackTrace();
        }


    }
}
