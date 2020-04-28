package com.netcracker.ec.provisioning.operations;

import com.netcracker.ec.model.db.NcObjectType;
import com.netcracker.ec.services.console.Console;
import com.netcracker.ec.services.db.impl.NcAttrService;
import com.netcracker.ec.services.db.impl.NcObjectService;
import com.netcracker.ec.services.db.impl.NcObjectTypeService;
import com.netcracker.ec.services.db.impl.NcParamsService;
import com.netcracker.ec.util.UserInput;
import com.netcracker.ec.view.Printer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ShowOrdersOperation implements Operation {
    private final NcObjectTypeService ncObjectTypeService;
    private final NcAttrService ncAttributeService;
    private final NcObjectService ncObjectService;
    private final NcParamsService ncParamsService;

    public ShowOrdersOperation() {
        this.ncObjectTypeService = new NcObjectTypeService();
        this.ncAttributeService = new NcAttrService();
        this.ncObjectService = new NcObjectService();
        this.ncParamsService = new NcParamsService();
    }

    @Override
    public void execute() {
        Printer.print("\nAll Orders: ");

        Map<Integer, NcObjectType> orderObjectTypeMap = ncObjectTypeService.getOrderObjectTypes();
        orderObjectTypeMap.forEach((key, value) -> Printer.print(key + " - " + value.getName()));

        Integer objectTypeId = UserInput.getOrderTypeId(orderObjectTypeMap.keySet());
        NcObjectType selectedObjectType = orderObjectTypeMap.get(objectTypeId);

        ResultSet order = selectOrders();

        try {
            int count = 1;
            while (order.next()) {
                String orderName = order.getString("name");
                if (substringInString(orderName, generateOrderName(selectedObjectType))){
                    Printer.print("Order" + count + " Name: " + orderName);
                    ResultSet resultSet = selectSetOrderParams(selectedObjectType.getId());
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        int attrTypeDefId = resultSet.getInt("attr_type_def_id");
                        Printer.print("\t" + name + ": " + attrTypeDefId);
                    }
                count++;}
            }
        } catch (SQLException ex) {
            Printer.print(ex.toString());
        }
    }

    private ResultSet selectOrders() {
        return ncObjectService.selectOrdersObject();
    }

    private ResultSet selectSetOrderParams(int id) {
        return ncObjectService.selectOrder(id);
    }

    private String generateOrderName(NcObjectType objectType) {
        return String.join(" ", UserInput.scan(objectType).next());
    }

    private boolean substringInString(String name, String substring) {
        int index = name.indexOf(substring);
        return !(index == -1);
    }
}
