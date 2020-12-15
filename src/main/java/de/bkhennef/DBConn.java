package de.bkhennef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn {

    private static final String portNumber = "600";
    private static final String serverName = "localhost";

    public static Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");

        conn = DriverManager.getConnection(
               "jdbc:mysql://" +
                       serverName +
                   ":" + portNumber + "/tb_ie81",
                   connectionProps);

        System.out.println("Connected to DB");
        return conn;
    }

}
