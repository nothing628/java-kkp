package com.kkp.myapp;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class Configuration {

    public static Configuration current;
    private String dbHost;
    private int dbPort;
    private String dbUser;
    private String dbPassword;
    private String dbName;
    private boolean isInstalled;

    static {
        Configuration tmp = new Configuration();

        current = tmp.Load();
    }

    public Configuration() {
    }

    public Configuration Load() {
        String fileContent = this.loadConfigFile();
        Configuration content = this.fromJson(fileContent);

        if (content == null) {
            content = new Configuration();
        }

        return content;
    }

    public void Save() {
        String configJson = this.toJson();

        this.writeConfigFile(configJson);
    }

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

    public void setIsInstalled(boolean is_installed) {
        isInstalled = is_installed;
    }

    public boolean isInstalled() {
        return isInstalled;
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

    private void writeConfigFile(String content) {
        try {
            try (FileWriter myWriter = new FileWriter("config.json")) {
                myWriter.write(content);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String loadConfigFile() {
        StringBuilder builder = new StringBuilder();

        try {
            File myObj = new File("config.json");
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();

                    builder.append(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return builder.toString();
    }

    private Configuration fromJson(String content) {
        Gson gson = new Gson();

        Configuration result = gson.fromJson(content, Configuration.class);

        return result;
    }

    private String toJson() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
