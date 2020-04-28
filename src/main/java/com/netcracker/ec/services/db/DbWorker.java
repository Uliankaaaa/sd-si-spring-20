package com.netcracker.ec.services.db;

import com.netcracker.ec.services.db.connection.MySqlConnection;
import com.netcracker.ec.view.Printer;
import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
public class DbWorker {
    private Connection connection;
    private static DbWorker dbWorker = null;

    private DbWorker() {
        try {
            this.connection = new MySqlConnection().getConnection();
        } catch (Exception e) {
            System.err.println("SqlException: \n" + e);
            throw new RuntimeException(e);
        }
    }

    public static DbWorker getInstance() {
        if (dbWorker == null) {
            dbWorker = new DbWorker();
        }
        return dbWorker;
    }

    public ResultSet executeSelect(String request) {
        try {
            PreparedStatement ps = connection.prepareStatement(request);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeInsert(String request) {
        try {
            PreparedStatement ps = connection.prepareStatement(request);
            ps.execute();
        } catch (SQLException e) {
            Printer.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
