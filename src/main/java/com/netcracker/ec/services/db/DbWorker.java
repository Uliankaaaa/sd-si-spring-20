package com.netcracker.ec.services.db;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Getter
public class DbWorker {
    private Connection connection;
    private static DbWorker dbWorker = null;

    private DbWorker() {
        try {
            this.connection = new MySqlConnection().getConnection();
        } catch (Exception e) {
            System.err.println("SqlException: \n" + e);
          //  log.error.println("SQLException:\n" + e);
            throw new RuntimeException(e);
        }
    }

    public static DbWorker getInstance() {
        if (dbWorker == null) {
            dbWorker = new DbWorker();
        }
        return dbWorker;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
         //   log.error.println("SQLException:\n" + e);
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
