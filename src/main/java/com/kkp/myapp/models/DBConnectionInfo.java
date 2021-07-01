package com.kkp.myapp.models;

import com.mongodb.ConnectionString;

public class DBConnectionInfo {
    private String dbHost;
    private int dbPort;
    private String dbUser;
    private String dbPassword;
    private String dbName;
    
    public void setHost(String host) {
        dbHost = host;
    }

    public void setDbName(String dbname) {
        this.dbName = dbname;
    }
    
    public void setPort(int port) {
        dbPort = port;
    }

    public void setUser(String user) {
        dbUser = user;
    }

    public void setPassword(String password) {
        dbPassword = password;
    }

    public String getHost() {
        return dbHost;
    }

    public String getDbName() {
        return dbName;
    }
    
    public int getPort() {
        return dbPort;
    }

    public String getUser() {
        return dbUser;
    }

    public String getPassword() {
        return dbPassword;
    }
    
    public ConnectionString getConnectionString() {
        String connStr = String.format("mongodb://%s:%s@%s:%d/%s", dbUser, dbPassword, dbHost, dbPort, dbName);
        
        return new ConnectionString(connStr);
    }
}
