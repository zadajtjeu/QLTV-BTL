package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MConnection {
    private final String DBHost = "den1.mssql7.gear.host";
    private final String DBName = "dbqltv";
    private final String user = "dbqltv";
    private final String pass = "Id50d4p!1b8-";
    private static  MConnection instance = new MConnection();
    private MConnection(){

    }

    public static MConnection getInstance() {
        return instance;
    }

    public Connection getConnection(){

        String url = "jdbc:sqlserver://"+DBHost+":1433;databaseName="+DBName+";user=" + user + ";password=" + pass;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
