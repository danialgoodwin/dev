package com.danialgoodwin.practice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample for connecting to server via SSH and MySQL database on that server using port forwarding.
 *
 * All the implementation is encapsulated, providing a simple API for the connections.
 */
public class Main {

    public static void main(String[] args) {
        String serverHost = "123.456.123.456";
        String serverUsername = "my-server-username";
        String sshKeyFilePath = "~/.ssh/id_rsa";
        int localPort = 8765; // Somewhat arbitrary, not all ports can be used. Make sure firewall isn't blocking.
        String databaseName = "my-database-name";
        String databaseUsername = "my-database-username";
        String databasePassword = "my-database-password";
        int databasePort = 3306; // Default port for MySQL.

        SshConnection sshConnection = new SshConnection(serverHost, serverUsername, sshKeyFilePath);
        DatabaseConnection databaseConnection = new DatabaseConnection(localPort, databaseName, databaseUsername, databasePassword);

        // Example connecting to server via SSH and performing a command.
        sshConnection.start();
        String pwd = sshConnection.unsafeExecute("pwd");
        System.out.println("pwd=" + pwd);

        // Now, connecting to database.
        sshConnection.setPortForwarding(localPort, databasePort);
        databaseConnection.start();

        List<String> rows = getRows(databaseConnection);
        System.out.println("rows=" + rows);

        databaseConnection.stop();
        sshConnection.stop();
    }

    private static List<String> getRows(DatabaseConnection connection) {
        List<String> results = new ArrayList<>();
        ResultSet resultSet = connection.unsafeExecute("SELECT name, idea FROM my_table;");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    String row = resultSet.getString("name");
                    row += "," + resultSet.getString("idea");
                    results.add(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
