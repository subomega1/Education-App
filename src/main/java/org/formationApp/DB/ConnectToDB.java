package org.formationApp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

    public Connection getConnection() throws SQLException {
        String password = "";
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/fomation_app";
        Connection connection = DriverManager.getConnection(url, user, password);
            return connection;

    }



}
