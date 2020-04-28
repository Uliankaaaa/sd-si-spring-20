package com.netcracker.ec.util;

import com.netcracker.ec.model.db.NcObjectType;
import java.util.Scanner;
import java.util.Set;

public class UserInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString(String msg) {
        String value;

        while (true) {
            System.out.println(msg);
            if (scanner.hasNextLine()) {
                value = scanner.nextLine();
                break;
            } else {
                scanner.nextLine();
            }
        }
        return value;
    }

    public static boolean getSaveDialogueAnswer() {
        return scanner.next().equals("Y");
    }

    public static void close() {
        scanner.close();
    }

    public static String nextOperationCommand() {
        return scanner.next();
    }

    private static Integer nextOperationId() {
        return scanner.nextInt();
    }

    public static Integer getOrderTypeId(Set<Integer> numberSet) {
        Integer id;
        do {
            id = nextOperationId();
        } while (!numberSet.contains(id));
        return id;
    }

    public static Scanner scan(NcObjectType objectType) {
        return new Scanner(objectType.getName());
    }
}