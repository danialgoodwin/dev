/**
 * Created by Danial on 8/18/15.
 */
package com.danialgoodwin.practice;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// More info:
// - Great: http://stackoverflow.com/questions/16468475/sending-commands-to-remote-server-through-ssh-by-java-with-jsch
/**
 * Use this class to encapsulate server connection via SSH.
 */
public class SshConnection {

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final int SERVER_PORT = 22;

    private Session mSshSession = null;

    private final String SERVER_HOST;
    private final String SERVER_USERNAME;
    private final String SSH_KEY_FILE_PATH;
    private final String SSH_PASSWORD;
    private final boolean IS_USE_PASSWORD;

    /**
     *
     * Note: This is currently set to SERVER_PORT=22.
     *
     * @param serverUserName the username to log into the server
     * @param serverHost URL or IP address
     * @param sshKeyFilePath full path of SSH KEY, typically "~/.ssh/id_rsa"
     */
    public SshConnection(String serverHost, String serverUserName, String sshKeyFilePath) {
        this(serverHost, serverUserName, sshKeyFilePath, null);
    }

    /**
     *
     * Note: This is currently set to SERVER_PORT=22.
     *
     * @param serverUserName the username to log into the server
     * @param serverHost URL or IP address
     * @param sshKeyFilePath full path of SSH KEY, typically "~/.ssh/id_rsa"
     * @param sshPassword password to use, or null to not use password
     */
    public SshConnection(String serverHost, String serverUserName, String sshKeyFilePath, String sshPassword) {
        SERVER_HOST = serverHost;
        SERVER_USERNAME = serverUserName;
        SSH_KEY_FILE_PATH = sshKeyFilePath;
        SSH_PASSWORD = sshPassword;
        IS_USE_PASSWORD = sshPassword != null;

        //noinspection TryWithIdenticalCatches
        try {
            Class.forName(DRIVER_NAME).newInstance(); // Loads driver.
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Note: Seems like can't extract session to constructor: http://stackoverflow.com/questions/12837036/jsch-how-to-reuse-a-session
    public void start() {
        try {
            JSch jsch = new JSch();
            mSshSession = jsch.getSession(SERVER_USERNAME, SERVER_HOST, SERVER_PORT);
            if (IS_USE_PASSWORD) {
                mSshSession.setPassword(SSH_PASSWORD);
            } else {
                jsch.addIdentity(SSH_KEY_FILE_PATH);
            }
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("ConnectionAttempts", "3");
            mSshSession.setConfig(config);
            System.out.println("SSH Connecting");
            mSshSession.connect();
            System.out.println("SSH Connected");
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    /**
     * Note: Only call this when connection is started.
     * @param localPort port for local machine
     * @param remotePort port for remote machine
     * @return the local port that is used, or Integer.MAX_VALUE if error.
     */
    public int setPortForwarding(int localPort, int remotePort) {
        int assignedLocalPort = Integer.MAX_VALUE;
        try {
            String remoteHost = "127.0.0.1";
            assignedLocalPort = mSshSession.setPortForwardingL(localPort, remoteHost, remotePort);
            System.out.println("localhost:" + assignedLocalPort + " -> " + remoteHost + ":" + remotePort);
            System.out.println("Port Forwarded");
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return assignedLocalPort;
    }

    public void stop() {
        if (mSshSession != null && mSshSession.isConnected()) {
            System.out.println("Closing SSH Connection");
            mSshSession.disconnect();
        }
    }

    /**
     * This is a dangerous execute that doesn't check the query. Validate before calling.
     *
     * Note: Currently, environments from one call don't carry over to the next. For example,
     * doing `cd ..` doesn't change the `pwd` for the next call to this method. If you
     * need multiple commands in one go, then you can format query as mentioned in:
     * http://stackoverflow.com/questions/5831594/multiple-commands-through-jsch-shell
     * @param command the command to execute
     * @return the results of the command, or null if error.
     */
    public String unsafeExecute(String command) {
        //noinspection TryWithIdenticalCatches
        try {
            ChannelExec channel = (ChannelExec) mSshSession.openChannel("exec");
            channel.setCommand(command); // Must go before connect() to work.
            channel.setErrStream(System.err);
            channel.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String msg;
            while ((msg = in.readLine()) != null) {
                sb.append(msg).append("\n");
            }

            channel.disconnect();
            return sb.toString();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
