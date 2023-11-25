package ATM.Interface.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionManager {

    Connection connection;
    Statement statement;

    public ConnectionManager() {
        String urlString = "jdbc:mysql:///<database name>";
        final String username = "<uesr>";
        final String password = "<password>";

        try {
            // 1. Register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Create Connection
            connection = DriverManager.getConnection(urlString, username, password);
            // 3. Create statement
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
