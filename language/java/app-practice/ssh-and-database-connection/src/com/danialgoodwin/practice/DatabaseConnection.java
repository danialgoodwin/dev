/**
 * Created by Danial on 8/18/15.
 */
package com.danialgoodwin.practice;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Use this class to encapsulate database connection.
 *
 * Note: If the database needs an SSH connection to reach, then start `SshConnection` before starting this.
 */
public class DatabaseConnection {

    private Connection mDatabaseConnection = null;
    private MysqlDataSource mDataSource;

    public DatabaseConnection(int localPort, String databaseName, String databaseUsername, String databasePassword) {
        String localSshUrl = "localhost";
        mDataSource = new MysqlDataSource();
        mDataSource.setServerName(localSshUrl);
        mDataSource.setPortNumber(localPort);
        mDataSource.setUser(databaseUsername);
        mDataSource.setAllowMultiQueries(true);
        mDataSource.setPassword(databasePassword);
        mDataSource.setDatabaseName(databaseName);
    }

    public void start() {
        try {
            mDatabaseConnection = mDataSource.getConnection();
            System.out.print("Connection to server successful!: " + mDatabaseConnection + "\n\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if (mDatabaseConnection != null && !mDatabaseConnection.isClosed()) {
                System.out.println("Closing Database Connection");
                mDatabaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is a dangerous execute that doesn't check the query. Validate before calling.
     * @param query the query to execute, including the semi-colon
     * @return the results of the query
     */
    public ResultSet unsafeExecute(String query) {
        ResultSet resultSet = null;
        try {
            Statement stmt = mDatabaseConnection.createStatement();
            resultSet = stmt.executeQuery(query);
            System.out.println("Database query successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
