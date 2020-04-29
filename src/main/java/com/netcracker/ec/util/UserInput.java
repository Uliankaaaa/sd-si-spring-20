package com.netcracker.ec.util;

import com.netcracker.ec.model.db.NcObjectType;

import java.util.Scanner;
import java.util.Set;

public class UserInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String YES = "Y";
 //   private static final String NO = "N";

    public static String inputString(String msg) {
        String value;

        while (true) {
            System.out.print(msg);
            if (scanner.hasNextLine()) {
                value = scanner.next();
                break;
            } else {
                scanner.next();
            }
        }
        return value;
    }

    public static boolean getSaveDialogueAnswer() {
        return scanner.next().equalsIgnoreCase(YES);
    }

    public static void close() {
        scanner.close();
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