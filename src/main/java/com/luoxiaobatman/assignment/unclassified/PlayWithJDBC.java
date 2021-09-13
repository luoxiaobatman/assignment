package com.luoxiaobatman.assignment.unclassified;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayWithJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foo?user=root&password=root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into foo (`field`) values ('bar')");
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
