package com.netcracker.ec.services.console;

import com.netcracker.ec.model.db.NcAttribute;
import com.netcracker.ec.model.domain.enums.OperationType;
import com.netcracker.ec.model.domain.oder.Order;
import com.netcracker.ec.provisioning.operations.CreateOrderOperation;
import com.netcracker.ec.provisioning.operations.ExitOperation;
import com.netcracker.ec.provisioning.operations.Operation;
import com.netcracker.ec.provisioning.operations.ShowOrdersOperation;
import com.netcracker.ec.services.db.impl.NcObjectService;
import com.netcracker.ec.util.UserInput;
import com.netcracker.ec.view.Printer;

public class Console {
    private static Console console = null;

    public static Console getInstance() {
        if (console == null) {
            console = new Console();
        }
        return console;
    }

    public static Operation getNextOperation() {

        Operation operation = null;
        String operationId = UserInput.inputString("Enter operation: \n" +
                "1 - Create Order\n" +
                "2 - Show Orders\n" +
                "3 - Exit");
        OperationType operationType = OperationType.getOperationById(operationId);
        try {
            switch (operationType) {
                case CREATE_ORDER:
                    operation = new CreateOrderOperation();
                    break;
                case SHOW_ORDERS:
                    operation = new ShowOrdersOperation();
                    break;
                case EXIT:
                    operation = new ExitOperation();
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Printer.print("Enter right operation");
            getNextOperation();
        }
        return operation;

    }

    public String getAttributeValue(NcAttribute attr) {
        Printer.print(attr.getName() + ": ");
        return UserInput.nextOperationCommand();
    }

    public void printOrderInfo(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order name: " + order.getName() + "\n");
        order.getParameters().forEach((key, value) ->
                stringBuilder.append("  ")
                        .append(key.getName())
                        .append(": ")
                        .append(value)
                        .append("\n"));
        Printer.print(stringBuilder.toString());
    }

    public boolean getSaveDialogueAnswer() {
        Printer.print("Save order?[Y/N]");
        return UserInput.getSaveDialogueAnswer();
    }

    public void close() {
        Printer.print("Exit in process...");
        UserInput.close();
    }
}