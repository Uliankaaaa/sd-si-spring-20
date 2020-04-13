package com.netcracker.ec.services.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    private String url;

    public MySqlConnection() {
        this.url = "jdbc:mysql://localhost:3306/ncProject";
    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, "root", "uliana");
    }
}
