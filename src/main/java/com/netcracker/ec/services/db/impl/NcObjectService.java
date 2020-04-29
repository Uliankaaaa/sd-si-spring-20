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
        String sqlQuery = "select * from nc_objects o, nc_object_types ot\n" +
                " where o.object_type_id = ot.object_type_id and ot.parent_id = 2";

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
}