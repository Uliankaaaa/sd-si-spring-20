package com.netcracker.ec.services.db.impl;

import com.netcracker.ec.model.domain.oder.Order;
import com.netcracker.ec.services.db.DbWorker;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NcObjectService {
    private static final DbWorker dbWorker = DbWorker.getInstance();

    public NcObjectService() {
    }

    public Order insertOrder(Order order) {
        String sqlQuery = String.format("insert into nc_objects values(%d, '%s', %d, null);",
                order.getId(),
                order.getName(),
                order.getObjectType().getId());
        dbWorker.executeInsert(sqlQuery);

        return order;
    }

    public ResultSet selectOrdersObject() {
        String sqlQuery = "select * from nc_objects where object_type_id in (1, 2, 3)";

        return dbWorker.executeSelect(sqlQuery);
    }

    public ResultSet selectOrder(int id) {
        String sqlQuery = "select a.attr_id, ao.object_type_id," +
                "a.name, a.attr_type_def_id, d.type " +
                "from nc_attr_object_types ao " +
                "inner join nc_attributes a " +
                "on ao.attr_id = a.attr_id " +
                "inner join nc_attr_type_defs d " +
                "on a.attr_type_def_id = d.attr_type_def_id " +
                "where ao.object_type_id in (2, " + id + ");";

        return dbWorker.executeSelect(sqlQuery);
    }


    public Integer getNextId() {
        Integer id = null;
        try {
            String sqlQuery = "select * from nc_id_keeper;";
            ResultSet resultSet = dbWorker.executeSelect(sqlQuery);
            resultSet.next();
            id = resultSet.getInt(1);
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}