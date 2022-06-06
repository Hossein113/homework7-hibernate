package maktab74.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnected {

    private Connection connection;
    private String url;
    private String username;
    private String password;


    public DatabaseConnected() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.url = "jdbc:mysql://localhost:3306";
        this.username = "root";
        this.password = "Hossein@9368";


        connection = DriverManager.getConnection(url, username, password);

    }

    public Connection getConnection() {
        return this.connection;
    }
}
