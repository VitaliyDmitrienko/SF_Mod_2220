// SkillFactory Module 22.2.

package org.example;

import java.sql.*;

public class Main2 {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=987654321";

    private static String conok="Соединение с бд установлено";
    private static String conerr="Произошла ошибка подключения к бд";


    public static void main(String[] args) throws SQLException {

        try (Connection connection = DriverManager.getConnection(URL)){
            System.out.println(String.format("%s",conok));

//            String s = "SELECT * from test;";
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM test";
//
//            boolean isExecuted=statement.execute(sql);
//            if (isExecuted){
//                System.out.println("Select executed");
//            }
//
//            statement.close();
//            connection.close();

            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("ID");
            System.out.println("||------------||");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("ID"));
            }
            System.out.println("||------------||");

            statement.close();
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(String.format("%s",conerr));
            e.printStackTrace();
        }


    }
}
