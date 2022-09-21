package com.login_subsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Validator {
    private final static String databaseConnectionURL = "jdbc:mysql://127.0.0.1:3306/project278";
    private final static String databaseUser = "root";
    private final static String databasePassword = "first92992%sqlme8*:";

    protected static boolean isValidCredentials(String username, String password) {
        try {
//            Load the jdbc driver which will mediate between database and my java program.
            Class.forName("com.mysql.cj.jdbc.Driver");

//            Get connected with database.
            Connection connection = DriverManager.getConnection(databaseConnectionURL, databaseUser, databasePassword);

//            Create a statement.
            Statement statement = connection.createStatement();

//            Perform a query and store in a resultSet.
            ResultSet resultSet = statement.executeQuery("SELECT username, password FROM user WHERE username='" + username + "'and password='" + password + "';");

            while (resultSet.next()) {
                String userNameNow = resultSet.getString(1).strip().toLowerCase(), passwordNow = resultSet.getString(2).strip();
                if (userNameNow.equals(username) && passwordNow.equals(password)) return true;
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    protected static boolean isValidMail(String mail) {
        return true;
    }

    protected static boolean isValidPassword(String password) {
        return password.strip().length() >= 8;
    }
}
