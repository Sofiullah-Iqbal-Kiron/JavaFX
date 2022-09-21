package com.login_subsystem;

import java.util.Scanner;

public class DataBaseInfo {
    private final static String ConnectionURL = "jdbc:mysql://127.0.0.1:3306/project278";
    private final static String UserName = "root";
    private final static String Password = "first92992%sqlme8*:";

    protected static String getConnectionURL() {
        return ConnectionURL;
    }

    protected static String getUserName() {
        return UserName;
    }

    protected static String getPassword() {
        return Password;
    }
}
